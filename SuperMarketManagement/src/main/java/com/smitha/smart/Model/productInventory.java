package com.smitha.smart.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

//for the admin reference
@Document(collection = "ProductInventory")
public class productInventory {
    @Id
    private String productId;
    @NotNull
    private String productName;
    @NotNull
    private double costPrice;
    @NotNull
    private double sellingPrice;
    @NotNull
    private int quantity;

    public productInventory(String productId, double costPrice, double sellingPrice, int quantity) {
        this.productId = productId;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }
    public productInventory(){

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
    public double getCostPrice(){
        return this.costPrice;
    }
    public void setCostPrice(double costPrice){
        this.costPrice = costPrice;
    }
    public double getSellingPrice(){
        return this.sellingPrice;
    }
    public void setSellingPrice(double sellingPrice){
        this.sellingPrice = sellingPrice;
    }
    public int getProductQuantity(){
        return this.quantity;
    }
    public void setProductQuantity(int units){
        this.quantity = units;
    }
}
