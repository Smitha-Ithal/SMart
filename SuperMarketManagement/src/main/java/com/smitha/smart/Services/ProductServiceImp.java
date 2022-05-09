package com.smitha.smart.Services;

import com.smitha.smart.Model.products;
import com.smitha.smart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public int insertProducts(products product){
        productRepository.save(product);
        return 1;
    }

    @Override
    public Optional<products> getProductById(String id){
        Optional<products> o = productRepository.findById(id);
        if(o.isPresent()){
            return o;
        }
        else{
            System.out.println("Not found!");
            return null;
        }
    }

    @Override
    public List<products> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public int updateProduct(String productId, products product){
        Optional<products> existingProduct = productRepository.findById(productId.toString());
        if(existingProduct.isPresent()){
            products updateProduct = existingProduct.get();
            if(product.getProduct_name() != null){
                updateProduct.setProduct_name(product.getProduct_name());
            }
            if(product.getProductCategories() != null){
                updateProduct.setProductCategories(product.getProductCategories());
            }
            if(product.getProduct_description() != null){
                updateProduct.setProduct_description(product.getProduct_description());
            }
            productRepository.save(updateProduct);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteProduct(String id){
        productRepository.deleteById(id);
        return 1;
    }
}
