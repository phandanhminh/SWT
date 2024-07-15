package com.example.swp_jewelryproductionordersystem.services;


import com.example.swp_jewelryproductionordersystem.entities.OrderDetails;
import com.example.swp_jewelryproductionordersystem.repositories.OrderDetailRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetails saveOrderDetail(OrderDetails orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetails updateOrderDetail(OrderDetails orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public OrderDetails getOrderDetailById(int id) {
        Optional<OrderDetails> optionalOrderDetail = orderDetailRepository.findById(id);
        return optionalOrderDetail.orElse(null);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }
}
