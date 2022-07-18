package com.dom.food.order.services;

import com.dom.food.order.mapper.OrderMapper;
import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderListModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public CartItemModel addToCart(CartItemModel cart) throws HttpResponseException {
        if (this.existInPrevious2DayOrder( cart.getUserId() ,cart.getMenuId())) {
                cart.setIncreasePrice(true);
        }
        CartItemModel checkCartItem = this.orderMapper.checkCartItemExists(cart);

        if (checkCartItem != null) {
            cart.setQuantity(cart.getQuantity() + checkCartItem.getQuantity());
            cart.setCartItemId(checkCartItem.getCartItemId());
            return this.updateCart(cart);
        }
        if (this.orderMapper.addToCart(cart)) {
            return cart;
        } 
        throw new HttpResponseException(400, "failed");
    }

    public List<CartItemModel> getCartItems(Integer userId) {
        return this.orderMapper.getCartItems(userId);
    }

    public CartItemModel updateCart(CartItemModel cart) throws HttpResponseException {
        // return this.orderMapper.updateCart(cart) ? cart : null;
        if (this.orderMapper.updateCart(cart)) {
            return cart;
        }
        throw new HttpResponseException(400, "failed");
    }

    public boolean removeFromCart(CartItemModel cart) throws HttpResponseException {
        if (this.orderMapper.removeFromCart(cart)) {
            return true;
        }
        throw new HttpResponseException(400, "failed");
    }

    public OrderModel checkOutCart(OrderModel order) throws HttpResponseException {
        OrderModel newOrder = this.createOrder(order);
        if (newOrder != null) {
            return newOrder;
        }
        throw new HttpResponseException(400, "fail");
    }

    public List<OrderListModel> getOrderList(Integer shopId, Integer userId) {
        return this.orderMapper.getOrderList(shopId, userId);
    }

    public boolean confirmPayment(PaymentModel payment) throws HttpResponseException {
        if (this.orderMapper.createPayment(payment)) {
            return true;
        }
        throw new HttpResponseException(400, "fail");
        // return this.orderMapper.createPayment(payment);
                // ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                // : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean confirmDelivered(Integer orderId) throws HttpResponseException {
        if (this.orderMapper.confirmDelivered(orderId)) {
            return true;
        }
        throw new HttpResponseException(400, "fail");
    }

    private OrderModel createOrder(OrderModel order) throws HttpResponseException {
        List<CartItemModel> cartItems = this.getCartItems(order.getCustomerId());
        if (cartItems.size() == 0) {
            throw new HttpResponseException(404, " no item in cart");
        }
        for (CartItemModel item : cartItems) {
            order.setGrandTotal(order.getGrandTotal() + item.getPrice() * item.getQuantity());
        }
        if (this.orderMapper.createOrder(order) > 0) {
            return this.createOrderDetail(order, cartItems) ? order : null;
        }
        throw new HttpResponseException(400, "fail");
        // return false;
    }

    private boolean createOrderDetail(OrderModel order, List<CartItemModel> cartItems) throws HttpResponseException {
        List<OrderDetailModel> orderDetail = new ArrayList<OrderDetailModel>();
        Integer index = 0;
        for (CartItemModel item : cartItems) {
            if (item.getIncreasePrice()) {
                // double price = ;
                item.setPrice(item.getPrice() + ( item.getPrice() * 0.05 ));
            }
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

    public boolean existInPrevious2DayOrder(Integer userId, Integer menuId) {
        LocalDate now = LocalDate.now();
        String today = (now.format(DateTimeFormatter.ISO_DATE));
        String yesterday = (now.minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        String dayBeforeYesterday = (now.minusDays(2)).format(DateTimeFormatter.ISO_DATE);
        String towDaysBeforeYesterday = (now.minusDays(2)).format(DateTimeFormatter.ISO_DATE);
        System.out.println(now);
        System.out.println(yesterday);
        System.out.println(dayBeforeYesterday);
        if (this.orderMapper.checkOrderByDate(today, dayBeforeYesterday, userId, menuId) && this.orderMapper.checkOrderByDate(yesterday, towDaysBeforeYesterday, userId, menuId)) {
            return true;
        }
        return false;
    }

}
