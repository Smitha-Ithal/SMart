package com.smitha.smart.Controller;

import com.smitha.smart.Model.products;
import com.smitha.smart.Services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImp productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public void insertProducts(@RequestBody products product){
        productService.insertProducts(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Optional<products> getProductsById(@PathVariable(value = "id") String id){
        return productService.getProductById(id);
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<products> getProducts(){
        return productService.getAllProducts();
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable(value = "id") String id, @RequestBody products product){
        productService.updateProduct(id, product);
    }
    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "id") String id){
        productService.deleteProduct(id);
    }
}
