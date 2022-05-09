package com.smitha.smart.Model;

import com.smitha.smart.PurchaseStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(value = "ProductPurchase")
public class productPurchase {
    @Id
    private String purchaseId;

    @NotEmpty
    private List<productPurchaseOrder> purchaseItems;
    @NotNull
    private double totalBill;
    private PurchaseStatus status;

    public productPurchase(List<productPurchaseOrder> purchaseItems, @NotNull double totalBill, PurchaseStatus status) {
        this.purchaseItems = purchaseItems;
        this.totalBill = totalBill;
        this.status = status;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<productPurchaseOrder> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<productPurchaseOrder> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }
}
//todo add vendorid
