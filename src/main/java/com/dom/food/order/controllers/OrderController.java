package com.dom.food.order.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;
import com.dom.food.order.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/cart")
    public ResponseEntity<?> addToCart(@Valid @RequestBody CartItemModel cart) {
        return this.orderService.addToCart(cart);
    }

    @GetMapping("/cart/{userId}")
    public List<CartItemModel> getCartItems(@PathVariable("userId") String userId) {
        return this.orderService.getCartItems(Integer.parseInt(userId));
    }

    @PutMapping("/cart")
    public ResponseEntity<?> updateCart(@RequestBody CartItemModel cart) {
        return this.orderService.updateCart(cart);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<?> removeFromCart(@RequestBody CartItemModel cart) {
        return this.orderService.removeFromCart(cart);
    }

    @PostMapping("/cart/checkout")
    public ResponseEntity<?> checkOut(@Valid @RequestBody OrderModel order) throws HttpResponseException {
        return this.orderService.checkOutCart(order);
    }

    @GetMapping("/{shopId}")
    public List<Object> getOrderList(@PathVariable("shopId") String shopId) {
        return this.orderService.getOrderList(Integer.parseInt(shopId));
    }

    @PostMapping("/confirm-payment")
    public ResponseEntity<?> removeFromCart(@Valid @RequestBody PaymentModel payment) {
        return this.orderService.confirmPayment(payment);
    }

    @PostMapping("/confirm-delivered/{orderId}")
    public ResponseEntity<?> confirmDelivered(@PathVariable("orderId") String orderId) {
        return this.orderService.confirmDelivered(Integer.parseInt(orderId));
    }

}
