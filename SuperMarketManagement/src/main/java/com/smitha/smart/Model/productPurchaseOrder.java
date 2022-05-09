package com.smitha.smart.Model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(value = "ProductPurchaseOrder")

public class productPurchaseOrder {

    @NotNull
    private String productId;
    @NotEmpty
    private int quantity;
    @NotEmpty
    private double purchasePrice;

    public productPurchaseOrder(String productId, int quantity, double purchasePrice){
        this.productId = productId;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


}
