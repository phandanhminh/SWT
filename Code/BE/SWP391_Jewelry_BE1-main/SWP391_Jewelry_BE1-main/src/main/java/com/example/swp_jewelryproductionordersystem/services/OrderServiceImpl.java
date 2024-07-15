package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Orders;
import com.example.swp_jewelryproductionordersystem.repositories.OrderRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders updateOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Orders getOrderById(int id) {
        Optional<Orders> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
