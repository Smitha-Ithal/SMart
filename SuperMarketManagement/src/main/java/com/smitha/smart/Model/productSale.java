package com.smitha.smart.Model;


import com.smitha.smart.SaleStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
//sale order
@Document(collection = "FinalOrder")
public class productSale {

    @Id
    private String orderId;
    @NotNull
    private List<productOrder> finalProducts;
    //@NotNull
    private double totalBill;
    private SaleStatus status;

    public productSale(List<productOrder> finalProducts, double totalBill, SaleStatus status)
     {
        this.finalProducts = finalProducts;
        this.totalBill = totalBill;
         this.status = status;
     }
    public String getOrderId(){
        return this.orderId;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    public List<productOrder> getFinalProducts(){
        return this.finalProducts;
    }
    public void setFinalProducts(List<productOrder> finalProducts){
        this.finalProducts = finalProducts;
    }
    public double getTotalBill(){
        return this.totalBill;
    }
    public void setTotalBill(double totalBill){
        this.totalBill = totalBill;
    }

    public SaleStatus getStatus(SaleStatus inprogress) {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }
}
