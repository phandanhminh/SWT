package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.OrderDetails;
import java.util.List;

public interface OrderDetailService {
    OrderDetails saveOrderDetail(OrderDetails orderDetail);
    OrderDetails updateOrderDetail(OrderDetails orderDetail);
    void deleteOrderDetail(int id);
    OrderDetails getOrderDetailById(int id);
    List<OrderDetails> getAllOrderDetails();
}
