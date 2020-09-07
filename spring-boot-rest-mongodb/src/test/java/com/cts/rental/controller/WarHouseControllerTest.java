package com.cts.rental.controller;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.rental.model.ProductResponse;
import com.cts.rental.repository.ProductRepository;
import com.cts.rental.service.Impl.WarHouseServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WarHouseController.class)
public class WarHouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private WarHouseServiceImpl warHouseServiceImpl;
    
    @Test
    public void shouldReturnProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldReturnParticularProduct() throws Exception {
    	ProductResponse product = new ProductResponse();
        given(warHouseServiceImpl.getDetailsOfProduct("1")).willReturn(product);
        mockMvc.perform(get("/products/1"))
                .andExpect(status().is2xxSuccessful());
    }
    

}