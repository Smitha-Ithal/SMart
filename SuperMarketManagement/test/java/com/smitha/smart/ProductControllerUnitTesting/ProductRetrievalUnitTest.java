package com.smitha.smart.ProductControllerUnitTesting;

import com.smitha.smart.Controller.ProductController;
import com.smitha.smart.Model.products;
import com.smitha.smart.ProductCategories;
import com.smitha.smart.Services.ProductService;
import com.smitha.smart.Services.ProductServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
@WithMockUser
public class ProductRetrievalUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImp productService;

    Optional<products> mockProduct = Optional.of(new products("Chianti", "Wine", ProductCategories.BEVERAGES));

    String exampleProductJson = "{\"product_name\":\"Chianti\",\"product_description\":\"Wine\",\"product_Category\":\"BEVERAGES\"}";

    @Test
    public void getProductDetails() throws Exception{
        Mockito.when(
                productService.getProductById(Mockito.anyString())).thenReturn(mockProduct);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(mvcResult.getResponse());

        String exepectedInput = "{product_id:62603a1b8c0935310d66da31, product_name:Chianti, product_description:Wine, product_category:BEVERAGES}";

        JSONAssert.assertEquals(exepectedInput, mvcResult.getResponse().getContentAsString(),false);
    }

}
