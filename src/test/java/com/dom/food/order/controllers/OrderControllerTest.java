package com.dom.food.order.controllers;


import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.OrdersModel;
import com.dom.food.order.models.PaymentModel;
import com.dom.food.order.services.OrderService;
import com.google.gson.Gson;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    OrderService orderService;

    Gson gson = new Gson();

    @Test
    void addToCart() throws Exception {
        CartItemModel cart = new CartItemModel();
        cart.setUserId(1).setMenuId(1).setQuantity(2);
        CartItemModel cartResponse = new CartItemModel();
        cartResponse.setCartItemId(1).setMenuId(1).setQuantity(2).setPrice(5).setTotalPrice(10);
        Mockito.when(orderService.addToCart(cart)).thenReturn(cartResponse);
        String content = gson.toJson(cart);
        mvc.perform(post("/order/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getCartItems() throws Exception {
        List<CartItemModel> cartItems = new ArrayList<CartItemModel>();
        cartItems.add(new CartItemModel(1, 1 , 1 , 2 , "nugget" , null , 5 , 1 , 1 , 10));
        cartItems.add(new CartItemModel(2, 2 , 1 , 2 , "coca" , null , 5 , 1 , 1 , 10));
        Mockito.when(orderService.getCartItems(1)).thenReturn(cartItems);
        mvc.perform(get("/order/cart/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.[0].name").value("nugget"));
    }

    @Test
    void updateCart() throws Exception {
        CartItemModel cart = new CartItemModel();
        cart.setUserId(1).setCartItemId(1).setQuantity(20);
        Mockito.when(orderService.updateCart(cart)).thenReturn(cart);
        String content = gson.toJson(cart);
        mvc.perform(put("/order/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }


    @Test
    void removeFromCart() throws Exception {
        CartItemModel cart = new CartItemModel();
        cart.setCartItemId(1).setUserId(1);
        Mockito.when(orderService.removeFromCart(cart)).thenReturn(true);
        String content = gson.toJson(cart);
        mvc.perform(delete("/order/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    void checkOut() throws Exception {
        OrderModel order = new OrderModel();
        order.setCustomerId(1).setDeliveryAddress("phnom penh");
        Mockito.when(orderService.checkOutCart(order)).thenReturn(true);
        String content = gson.toJson(order);
        mvc.perform(post("/order/cart/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());
    }


    @Test
    void getOrderList() throws Exception {
        List<OrdersModel> orders = new ArrayList<>();
        orders.add(new OrdersModel(null, 1, 10, 10,false, "dom" , "098765432", "phnom penh", "potato@mail.com", 1 , "nugget", "2022-07-14T07:50:55.000+00:00" ,"2022-07-14T14:50:55" ));
        orders.add(new OrdersModel(null, 1, 10, 10,false, "dom" , "098765432", "phnom penh", "potato@mail.com", 1 , "coca", "2022-07-14T07:50:55.000+00:00" ,"2022-07-14T14:50:55" ));
        Mockito.when(orderService.getOrderList(1 ,1 )).thenReturn(orders);
        mvc.perform(get("/order?userId=1&shopId=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("nugget"));

    }

    @Test
    void confirmPayment() throws Exception {
        PaymentModel payment = new PaymentModel();
        payment.setAmount(111).setPaidBy(1).setProcessedBy(2).setOrderId(1);
        Mockito.when(orderService.confirmPayment(payment)).thenReturn(true);
        String content = gson.toJson(payment);
        mvc.perform(post("/order/confirm-payment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());
    }

    @Test
    void confirmDelivered() throws Exception {
        Mockito.when(orderService.confirmDelivered(1)).thenReturn(true);
        mvc.perform(post("/order/confirm-delivered/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());
    }
}