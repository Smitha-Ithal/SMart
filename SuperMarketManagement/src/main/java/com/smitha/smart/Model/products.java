package com.smitha.smart.Model;

import com.smitha.smart.ProductCategories;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class products {
    @Id
    private String id;
    @Indexed(unique = true)
    private String product_name;
    private String product_description;
    private ProductCategories productCategories;

    public products(String product_name, String product_description, ProductCategories productCategories){
        this.product_name = product_name;
        this.product_description = product_description;
        this.productCategories = productCategories;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getProduct_name(){
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public String getProduct_description(){
        return product_description;
    }
    public void setProduct_description(String product_description){
        this.product_description = product_description;
    }
    public ProductCategories getProductCategories(){
        return productCategories;
    }
    public void setProductCategories(ProductCategories productcategories){
        this.productCategories = productcategories;
    }

}
