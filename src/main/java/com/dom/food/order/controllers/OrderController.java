package com.dom.food.order.controllers;

import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderListModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;
import com.dom.food.order.services.OrderService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/cart")
    public ResponseEntity<?> addToCart(@Valid @RequestBody CartItemModel cart) throws HttpResponseException {
        return ResponseEntity.created(null).body(this.orderService.addToCart(cart));
    }

    @GetMapping("/cart/{userId}")
    public List<CartItemModel> getCartItems(@PathVariable("userId") String userId) {
        return this.orderService.getCartItems(Integer.parseInt(userId));
    }

    @PutMapping("/cart")
    public ResponseEntity<?> updateCart(@RequestBody CartItemModel cart) throws HttpResponseException {
        return ResponseEntity.ok().body(this.orderService.updateCart(cart));
    }

    @DeleteMapping("/cart")
    public ResponseEntity<?> removeFromCart(@RequestBody CartItemModel cart) throws HttpResponseException {
        return ResponseEntity.ok().body(this.orderService.removeFromCart(cart));
    }

    @PostMapping("/cart/checkout")
    public ResponseEntity<?> checkOut(@Valid @RequestBody OrderModel order) throws HttpResponseException {
        return ResponseEntity.created(null).body(this.orderService.checkOutCart(order));
    }

    @GetMapping()
    public @ResponseBody List<OrderListModel> getOrderList(@RequestParam(defaultValue = "0") String shopId, @RequestParam(defaultValue = "0") String userId) {
        return this.orderService.getOrderList(Integer.parseInt(shopId), Integer.parseInt(userId));
    }

    @PostMapping("/confirm-payment")
    public ResponseEntity<?> removeFromCart(@Valid @RequestBody PaymentModel payment) throws HttpResponseException {
        return ResponseEntity.created(null).body(this.orderService.confirmPayment(payment)); 
    }

    @PostMapping("/confirm-delivered/{orderId}")
    public ResponseEntity<?> confirmDelivered(@PathVariable("orderId") String orderId) throws HttpResponseException, NumberFormatException {
        return ResponseEntity.created(null).body(this.orderService.confirmDelivered(Integer.parseInt(orderId))); 
    }

}
