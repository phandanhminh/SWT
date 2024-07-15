package com.example.swp_jewelryproductionordersystem.services.interfaces;
import com.example.swp_jewelryproductionordersystem.entities.Orders;

import java.util.List;

public interface OrderService {
    Orders saveOrder(Orders order);
    Orders updateOrder(Orders order);
    void deleteOrder(int id);
    Orders getOrderById(int id);
    List<Orders> getAllOrders();
}
