package com.smitha.smart.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//class to search and add individual products into the cart --> Add to Cart option SaleItem
@Document(collection = "ProductOrder")
public class productOrder {
    @Id
    private String productId;
    private String productName;
    private int quantity;

    public productOrder(String productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }
    public String getProductId(){
        return this.productId;
    }
    public void setProductId(String productId){
        this.productId = productId;
    }
    public String getProductName(){
        return this.productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
