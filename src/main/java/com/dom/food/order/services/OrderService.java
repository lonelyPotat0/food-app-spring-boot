package com.dom.food.order.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.order.mapper.OrderMapper;
import com.dom.food.order.models.CartItemModel;
// import com.dom.food.order.models.CartModel;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public ResponseEntity<?> addToCart(CartItemModel cart) {
        return this.orderMapper.addToCart(cart)
                ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public List<CartItemModel> getCartItems(Integer userId) {
        return this.orderMapper.getCartItems(userId);
    }

    public ResponseEntity<?> updateCart(CartItemModel cart) {

        return this.orderMapper.updateCart(cart)
                ? new ResponseEntity<String>("updated", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> removeFromCart(CartItemModel cart) {
        return this.orderMapper.removeFromCart(cart)
                ? new ResponseEntity<String>("deleted", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> checkOutCart() {
        return null;
    }

    public List<Object> listOrder(Integer shopId) {
        return null;
    }

    public ResponseEntity<?> confirmPayment() {
        return null;
    }

    public ResponseEntity<?> confirmDelivered() {
        return null;
    }

    // private CartModel createCart(CartModel cart) {
    // return this.orderMapper.createCart(cart);
    // }

    // private CartModel getCartInfo(Integer userId) {
    // return this.orderMapper.getCart(userId);
    // }
}
