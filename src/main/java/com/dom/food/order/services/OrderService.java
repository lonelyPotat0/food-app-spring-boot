package com.dom.food.order.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.order.mapper.OrderMapper;
import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderModel;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public ResponseEntity<?> addToCart(CartItemModel cart) {

        CartItemModel checkCartItem = this.orderMapper.checkCartItemExists(cart);

        if (checkCartItem != null) {
            cart.setQuantity(cart.getQuantity() + checkCartItem.getQuantity());
            cart.setCartItemId(checkCartItem.getCartItemId());
            return this.updateCart(cart);
        }

        return this.orderMapper.addToCart(cart)
                ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public List<CartItemModel> getCartItems(Integer userId) {
        return this.orderMapper.getCartItems(userId);
    }

    public ResponseEntity<?> updateCart(CartItemModel cart) {

        return this.orderMapper.updateCart(cart)
                ? new ResponseEntity<String>("updated", HttpStatus.OK)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> removeFromCart(CartItemModel cart) {
        return this.orderMapper.removeFromCart(cart)
                ? new ResponseEntity<String>("deleted", HttpStatus.OK)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> checkOutCart(OrderModel order) throws HttpResponseException {
        return this.createOrder(order)
                ? new ResponseEntity<String>("checked out", HttpStatus.OK)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
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

    private boolean createOrder(OrderModel cart) throws HttpResponseException {
        List<CartItemModel> cartItems = this.getCartItems(cart.getCustomerId());
        for (CartItemModel item : cartItems) {
            cart.setGrandTotal(cart.getGrandTotal() + item.getPrice() * item.getQuantity());
        }
        if (this.orderMapper.createOrder(cart) > 0) {
            return this.createOrderDetail(cart, cartItems) ? true : false;
        }
        return false;
    }

    private boolean createOrderDetail(OrderModel cart, List<CartItemModel> cartItems) throws HttpResponseException {
        List<OrderDetailModel> orderDetail = new ArrayList<OrderDetailModel>();
        Integer index = 0;
        for (CartItemModel item : cartItems) {
            orderDetail.add(new OrderDetailModel(cart.getOrderId(), item.getMenuId(), item.getQuantity(),
                    item.getPrice(), item.getUserId()));
            index++;
        }
        if (this.orderMapper.createOrderDetail(orderDetail)) {
            return this.orderMapper.clearCart(cart.getCustomerId());
        } else {
            // roll back
            this.orderMapper.deleteOrder(cart.getOrderId());
            throw new HttpResponseException(400, " error checking out cart");
        }

    }

}
