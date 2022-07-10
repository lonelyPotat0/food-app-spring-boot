package com.dom.food.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;

@Mapper
public interface OrderMapper {
    boolean createOrder(OrderModel order);

    boolean createOrderDetail(OrderDetailModel orderDetail);

    boolean createPayment(PaymentModel payment);

}
