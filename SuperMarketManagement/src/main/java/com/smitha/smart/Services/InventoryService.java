package com.smitha.smart.Services;

import com.smitha.smart.Model.productInventory;
import com.smitha.smart.Model.productOrder;
import com.smitha.smart.Model.productPurchaseOrder;
import com.smitha.smart.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public double totalBillAmount(List<productOrder> productOrders) {
        double amount = 0;
        for (productOrder i : productOrders) {
            amount += i.getQuantity() * inventoryRepository.findById(i.getProductId().toString()).get().getSellingPrice();
        }
        return amount;
    }
    public void productAvailabilityCheck(List<productOrder> productOrders){
        for (productOrder order: productOrders) {
            Optional<productInventory> existingOrder = inventoryRepository.findById(order.getProductId().toString());
            if(existingOrder.isPresent()){
                if(order.getQuantity() > existingOrder.get().getProductQuantity()){
                    System.out.println("Item Out of Stock!");
                }
            }
            else{
                System.out.println("not working!");
            }
        }
    }
    public void updateProductInventoryAfterSale(List<productOrder> productOrders){
        productInventory productInventory = new productInventory();
        for (productOrder order: productOrders) {
            Optional<productInventory> existingProduct = inventoryRepository.findById(order.getProductId());
            productInventory.setProductId(order.getProductId());
            productInventory.setProductQuantity(existingProduct.get().getProductQuantity() - order.getQuantity());
            inventoryRepository.save(productInventory);
        }
    }
    public void updateProductInventoryAfterPurchase(List<productPurchaseOrder> productPurchaseOrders){
        productInventory productInventory = new productInventory();
        for(productPurchaseOrder purchaseOrder : productPurchaseOrders){
            Optional<productInventory> existingProduct = inventoryRepository.findById(purchaseOrder.getProductId());
            double purchasePrice = purchaseOrder.getPurchasePrice();
            productInventory.setProductId(purchaseOrder.getProductId());
            productInventory.setSellingPrice(purchasePrice * (1.5 + 0.4));
            productInventory.setProductQuantity(existingProduct.get().getProductQuantity() + purchaseOrder.getQuantity());
            inventoryRepository.save(productInventory);
        }
    }
}
