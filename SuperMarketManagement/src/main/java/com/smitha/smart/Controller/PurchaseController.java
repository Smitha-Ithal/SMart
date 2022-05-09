package com.smitha.smart.Controller;

import com.smitha.smart.Model.productPurchase;
import com.smitha.smart.Services.ProductPurchaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class PurchaseController {
    @Autowired
    ProductPurchaseServiceImp productPurchaseService;

    @RequestMapping(value = "/purchase", method = POST)
    public void addPurchase(@RequestBody productPurchase product){
        productPurchaseService.addPurchase(product);
    }
    @RequestMapping(value = "/purchase", method = GET)
    public List<productPurchase> getAllPurchases(){
        return productPurchaseService.getAllPurchase();
    }
    @RequestMapping(value = "/purchase/{id}", method = GET)
    public productPurchase getPurchaseById(@PathVariable (value = "id") String purchaseId){
        return productPurchaseService.getPurchaseById(purchaseId);
    }
    @RequestMapping(value = "/purchase/{id}", method = PUT)
    public void updatePurchase( @PathVariable(value = "id") String purchaseId, @RequestBody productPurchase product){
        productPurchaseService.updatePurchaseOrder(purchaseId, product);
    }
    @RequestMapping(value = "/purchase/delete/{id}", method = DELETE)
    public void deletePurchase(@PathVariable(value = "id") String purchaseId){
        productPurchaseService.deletePurchase(purchaseId);
    }
    @RequestMapping(value = "/purchaseStatus/{id}", method = PATCH)
    public void purchaseStatusUpdate(@PathVariable(value = "id") String purchaseId){
        productPurchaseService.completePurchaseOrder(purchaseId);
    }

}
