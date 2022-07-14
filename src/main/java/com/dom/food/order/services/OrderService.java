package com.dom.food.order.services;

import com.dom.food.order.mapper.OrderMapper;
import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.OrdersModel;
import com.dom.food.order.models.PaymentModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public CartItemModel addToCart(CartItemModel cart) {

        CartItemModel checkCartItem = this.orderMapper.checkCartItemExists(cart);

        if (checkCartItem != null) {
            cart.setQuantity(cart.getQuantity() + checkCartItem.getQuantity());
            cart.setCartItemId(checkCartItem.getCartItemId());
            return this.updateCart(cart);
        }

        return this.orderMapper.addToCart(cart) ? cart : null;
                // ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public List<CartItemModel> getCartItems(Integer userId) {
        return this.orderMapper.getCartItems(userId);
    }

    public CartItemModel updateCart(CartItemModel cart) {

        return this.orderMapper.updateCart(cart) ? cart : null;
                // ? new ResponseEntity<String>("updated", HttpStatus.OK)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean removeFromCart(CartItemModel cart) {
        return this.orderMapper.removeFromCart(cart);
                // ? new ResponseEntity<String>("deleted", HttpStatus.OK)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean checkOutCart(OrderModel order) throws HttpResponseException {
        return this.createOrder(order);
                // ? new ResponseEntity<String>("checked out", HttpStatus.OK)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public List<OrdersModel> getOrderList(Integer shopId, Integer userId) {
        return this.orderMapper.getOrderList(shopId, userId);
    }

    public boolean confirmPayment(PaymentModel payment) {
        return this.orderMapper.createPayment(payment);
                // ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean confirmDelivered(Integer orderId) {
        return this.orderMapper.confirmDelivered(orderId);
                // ? new ResponseEntity<String>("confirmed", HttpStatus.OK)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    private boolean createOrder(OrderModel order) throws HttpResponseException {
        List<CartItemModel> cartItems = this.getCartItems(order.getCustomerId());
        if (cartItems.size() == 0) {
            throw new HttpResponseException(404, " no item in cart");
        }
        for (CartItemModel item : cartItems) {
            order.setGrandTotal(order.getGrandTotal() + item.getPrice() * item.getQuantity());
        }
        if (this.orderMapper.createOrder(order) > 0) {
            return this.createOrderDetail(order, cartItems) ? true : false;
        }
        return false;
    }

    private boolean createOrderDetail(OrderModel order, List<CartItemModel> cartItems) throws HttpResponseException {
        List<OrderDetailModel> orderDetail = new ArrayList<OrderDetailModel>();
        Integer index = 0;
        for (CartItemModel item : cartItems) {
            orderDetail.add(new OrderDetailModel(order.getOrderId(), item.getMenuId(), item.getQuantity(),
                    item.getPrice(), item.getUserId(), item.getShopId()));
            index++;
        }
        System.out.println("===================?" + orderDetail);
        if (this.orderMapper.createOrderDetail(orderDetail)) {
            try {
                return this.orderMapper.clearCart(order.getCustomerId());
            } catch (Exception err) {
                // roll back
                this.orderMapper.deleteOrder(order.getOrderId());
                throw new HttpResponseException(400, " error checking out cart");
            }
        }
        return false;

    }

}
