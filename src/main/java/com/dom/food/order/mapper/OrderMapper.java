package com.dom.food.order.mapper;

import com.dom.food.order.models.CartItemModel;
import com.dom.food.order.models.OrderDetailModel;
import com.dom.food.order.models.OrderListModel;
import com.dom.food.order.models.OrderModel;
import com.dom.food.order.models.PaymentModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



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

    List<OrderListModel> getOrderList(@Param("shopId") Integer shopId, @Param("userId") Integer userId);

    boolean createPayment(PaymentModel payment);

    boolean confirmDelivered(Integer orderId);

    boolean checkOrderByDate(@Param("dateBefore") String dateBefore, @Param("dateAfter") String dateAfter,@Param("userId") Integer userId, @Param("menuId") Integer menuId );
}
