package com.smitha.smart.Services;

import com.smitha.smart.Model.productPurchase;

import java.util.List;

public interface ProductPurchaseService {
    public void deletePurchase(String purchaseId);
    public int updatePurchaseOrder(String purchaseId, productPurchase purchase);
    public productPurchase getPurchaseById(String id);
    public List<productPurchase> getAllPurchase();
    public void addPurchase(productPurchase purchase);
    public void completePurchaseOrder(String id);
}
