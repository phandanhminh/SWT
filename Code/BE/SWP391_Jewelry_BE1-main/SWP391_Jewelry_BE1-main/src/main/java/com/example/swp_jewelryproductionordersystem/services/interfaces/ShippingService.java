package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Shippings;

import java.util.List;

public interface ShippingService {
    Shippings saveShipping(Shippings shippings);
    Shippings updateShipping(Shippings shippings);
    void deleteShipping(int id);
    Shippings getShippingById(int id);
    List<Shippings> getAllShippings();
}
