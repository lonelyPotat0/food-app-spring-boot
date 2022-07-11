package com.dom.food.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderModel;

@Mapper
public interface OrderMapper {

    CartItemModel checkCartItemExists(CartItemModel cartItem);

    boolean addToCart(CartItemModel cartItem);

    List<CartItemModel> getCartItems(Integer userId);

    boolean updateCart(CartItemModel cartItem);

    boolean removeFromCart(CartItemModel cartItem);

    Integer createOrder(OrderModel order);

    boolean createOrderDetail(List<OrderDetailModel> orders);

    boolean clearCart(Integer userId);

    boolean deleteOrder(Integer orderId);

}
