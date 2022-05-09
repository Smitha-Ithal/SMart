package com.smitha.smart.Services;

import com.smitha.smart.Model.productOrder;
import com.smitha.smart.Model.productPurchase;
import com.smitha.smart.Model.productPurchaseOrder;
import com.smitha.smart.PurchaseStatus;
import com.smitha.smart.Repository.ProductPurchaseRepository;
import com.smitha.smart.SaleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPurchaseServiceImp implements ProductPurchaseService {
    @Autowired
    private ProductPurchaseRepository purchaseRepository;
    @Autowired
    private InventoryService inventoryService;

    @Override
    public void addPurchase(productPurchase purchase) {
        purchase.setStatus(PurchaseStatus.INPROGRESS);
        List<productPurchaseOrder> orderList = purchase.getPurchaseItems();
        inventoryService.updateProductInventoryAfterPurchase(orderList);
        purchaseRepository.save(purchase);
    }


    @Override
    public List<productPurchase> getAllPurchase(){
        return purchaseRepository.findAll();
    }

    @Override
    public productPurchase getPurchaseById(String id){
        List<productPurchase> o = purchaseRepository.findAll();
        for(productPurchase purchase : o){
            if(purchase.getPurchaseId().equals(id)){
                return purchase;
            }
        }
        System.out.println("Purchase Not found!!");
        return null;
    }

    @Override
    public int updatePurchaseOrder(String purchaseId, productPurchase purchase){
        Optional<productPurchase> exisitingPurchase = purchaseRepository.findById(purchaseId.toString());
        if(exisitingPurchase.isPresent()){
            productPurchase updatePurchase = exisitingPurchase.get();
            if(purchase.getPurchaseItems() != null){
                updatePurchase.setPurchaseItems(purchase.getPurchaseItems());
                updatePurchase.setTotalBill(purchase.getTotalBill());
            }
            purchaseRepository.save(updatePurchase);
            return 1;
        }
        return 0;
    }

    @Override
    public void deletePurchase(String purchaseId){
        purchaseRepository.deleteById(purchaseId);
    }

    @Override
    public void completePurchaseOrder(String id){

        Optional<productPurchase> existingPurchase = purchaseRepository.findById(id.toString());
        if(existingPurchase.isPresent()){
            productPurchase updatePurchase = existingPurchase.get();
            inventoryService.updateProductInventoryAfterPurchase(updatePurchase.getPurchaseItems());
            updatePurchase.setStatus(PurchaseStatus.COMPLETED);
            purchaseRepository.save(updatePurchase);
//            return updatePurchase;
        }

    }


}
