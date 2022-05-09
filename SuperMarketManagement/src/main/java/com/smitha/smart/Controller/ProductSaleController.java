package com.smitha.smart.Controller;

import com.smitha.smart.Model.productSale;
import com.smitha.smart.Services.ProductSaleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

@RestController
public class ProductSaleController {
    @Autowired
    private ProductSaleServiceImp productSaleService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void addCart(@RequestBody productSale productsale) {
        productSaleService.addProductSale(productsale);
    }
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<productSale> getAllProductSale(){
        return productSaleService.getAllSaleOrder();
    }
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public productSale getProductSaleById(@PathVariable(value = "id") String id){
        return productSaleService.getSaleOrder(id);
    }
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public void updateProductSale(@PathVariable(value = "id") String id, @RequestBody productSale productSale1){
        productSaleService.updateSaleOrder(id, productSale1);
    }
    @RequestMapping(value = "/orderStatus/complete/{id}", method = PATCH)
    public productSale completeProductSale(@PathVariable(value = "id") String id){
       return productSaleService.completeSaleOrder(id);
    }
    @RequestMapping(value = "/orderStatus/cancel/{id}", method = PATCH)
    public productSale cancelProductSale(@PathVariable(value = "id") String id){
       return productSaleService.cancelSaleOrder(id);
    }
    @RequestMapping(value = "/order/delete/{id}", method = DELETE)
    public void deleteProduct(@PathVariable(value = "id") String id){
        productSaleService.deleteSaleOrder(id);
    }

}