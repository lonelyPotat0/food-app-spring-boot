package com.dom.food.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.order.models.CartItemModel;
// import com.dom.food.order.models.CartModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;

@Mapper
public interface OrderMapper {

    boolean addToCart(CartItemModel cartItem);

    List<CartItemModel> getCartItems(Integer userId);

    boolean updateCart(CartItemModel cartItem);

    boolean removeFromCart(CartItemModel cartItem);

    boolean createOrder(OrderModel order);

    boolean createOrderDetail(OrderDetailModel orderDetail);

    boolean createPayment(PaymentModel payment);

}
