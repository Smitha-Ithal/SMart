package com.smitha.smart.Services;

import com.smitha.smart.Model.products;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public int insertProducts(products product);
    public Optional<products> getProductById(String id);
    public List<products> getAllProducts();
    public int updateProduct(String productId, products product);
    public int deleteProduct(String id);
}
