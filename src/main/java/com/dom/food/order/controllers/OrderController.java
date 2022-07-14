package com.dom.food.order.controllers;

import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.OrdersModel;
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
    public ResponseEntity<?> addToCart(@Valid @RequestBody CartItemModel cart) {
        CartItemModel createdCartItem = this.orderService.addToCart(cart);
        return createdCartItem != null ? ResponseEntity.created(null).body(createdCartItem) : ResponseEntity.badRequest().body("fail");
    }

    @GetMapping("/cart/{userId}")
    public List<CartItemModel> getCartItems(@PathVariable("userId") String userId) {
        return this.orderService.getCartItems(Integer.parseInt(userId));
    }

    @PutMapping("/cart")
    public ResponseEntity<?> updateCart(@RequestBody CartItemModel cart) {
        CartItemModel updatedCartItem = this.orderService.updateCart(cart);
        return updatedCartItem != null ? ResponseEntity.ok().body(updatedCartItem) : ResponseEntity.badRequest().body("fail");
    }

    @DeleteMapping("/cart")
    public ResponseEntity<?> removeFromCart(@RequestBody CartItemModel cart) {
        return this.orderService.removeFromCart(cart)  ? ResponseEntity.ok().body("deleted" )
                                                        : ResponseEntity.badRequest().body("failed");
    }

    @PostMapping("/cart/checkout")
    public ResponseEntity<?> checkOut(@Valid @RequestBody OrderModel order) throws HttpResponseException {
        return this.orderService.checkOutCart(order)  ? ResponseEntity.created(null).body("checked out" )
                                                        : ResponseEntity.badRequest().body("failed");
    }

    @GetMapping()
    public @ResponseBody List<OrdersModel> getOrderList(@RequestParam(defaultValue = "0") String shopId, @RequestParam(defaultValue = "0") String userId) {
        return this.orderService.getOrderList(Integer.parseInt(shopId), Integer.parseInt(userId));
    }

    @PostMapping("/confirm-payment")
    public ResponseEntity<?> removeFromCart(@Valid @RequestBody PaymentModel payment) {
        return this.orderService.confirmPayment(payment) 
                            ? ResponseEntity.created(null).body("payment confirmed" )
                            : ResponseEntity.badRequest().body("failed");
    }

    @PostMapping("/confirm-delivered/{orderId}")
    public ResponseEntity<?> confirmDelivered(@PathVariable("orderId") String orderId) {
        return this.orderService.confirmDelivered(Integer.parseInt(orderId)) 
                            ? ResponseEntity.created(null).body("dilivery confirmed" )
                            : ResponseEntity.badRequest().body("failed");
    }

}
