package com.smitha.smart.Services;

import com.smitha.smart.Model.productSale;

import java.util.List;

public interface ProductSaleService {
    public void deleteSaleOrder(String orderId);
    public List<productSale> getAllSaleOrder();
    public productSale getSaleOrder(String orderId);
    public int addProductSale(productSale productsale);
    public productSale completeSaleOrder(String id);
    public productSale cancelSaleOrder(String id);
    public int updateSaleOrder(String orderId, productSale productSale1);
}
