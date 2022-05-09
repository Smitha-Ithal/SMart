package com.smitha.smart.Services;

import com.smitha.smart.Model.productOrder;
import com.smitha.smart.Model.productSale;
import com.smitha.smart.Repository.ProductSaleRepository;
import com.smitha.smart.SaleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSaleServiceImp implements ProductSaleService {
    @Autowired
    private ProductSaleRepository productSaleRepository;
    @Autowired
    private InventoryService inventoryService;

    @Override
    public int addProductSale(productSale productsale) {
        productsale.setStatus(SaleStatus.INPROGRESS);
        List<productOrder> orderList = productsale.getFinalProducts();
        inventoryService.productAvailabilityCheck(orderList);
        productsale.setTotalBill(inventoryService.totalBillAmount(orderList));
        productSaleRepository.save(productsale);
        inventoryService.updateProductInventoryAfterSale(orderList);
        return 1;
    }
    @Override
    public productSale getSaleOrder(String orderId){
        List<productSale> existingOrder = productSaleRepository.findAll();
        for (productSale sale: existingOrder) {
            if(sale.getOrderId().equals(orderId)){
                return sale;
            }

        }
        return null;
    }

    @Override
    public List<productSale> getAllSaleOrder(){

        return productSaleRepository.findAll();
    }

    @Override
    public int updateSaleOrder(String orderId, productSale productSale1){
        Optional<productSale> existingOrder = productSaleRepository.findById(orderId);
        if(existingOrder.isPresent()){
            productSale updateProductSale = existingOrder.get();
            if(productSale1.getFinalProducts()!=null){
                updateProductSale.setFinalProducts(productSale1.getFinalProducts());
                updateProductSale.setTotalBill(inventoryService.totalBillAmount(productSale1.getFinalProducts()));
            }
            productSaleRepository.save(updateProductSale);
            return 1;
        }
        return 0;
    }

    @Override
    public productSale cancelSaleOrder(String id){
        Optional<productSale> existingProductSale = productSaleRepository.findById(id.toString());
        if(existingProductSale.isPresent()){
            System.out.println(existingProductSale);
            productSale updateSale = existingProductSale.get();
            System.out.println(updateSale);
           updateSale.setStatus(SaleStatus.CANCELLED);
            System.out.println("Successfully Cancelled!");
            return updateSale;
        }
        return null;
    }

    @Override
    public productSale completeSaleOrder(String id){
        Optional<productSale> existingProductSale = productSaleRepository.findById(id.toString());
        if(existingProductSale.isPresent()){
            System.out.println(existingProductSale);
            productSale updateSale = existingProductSale.get();
            System.out.println(updateSale);
            updateSale.setStatus(SaleStatus.COMPLETED);
            productSaleRepository.save(updateSale);

            //update the inventory details
            inventoryService.updateProductInventoryAfterSale(updateSale.getFinalProducts());
            //inventoryService.updateProductInventoryAfterSale(updateSale.getFinalProducts());
            productSaleRepository.save(updateSale);
            return updateSale;
        }
        return null;
    }

    @Override
    public void deleteSaleOrder(String orderId){
        productSaleRepository.deleteById(orderId);
    }
}
