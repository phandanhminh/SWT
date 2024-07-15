package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Shippings;
import com.example.swp_jewelryproductionordersystem.repositories.ShippingRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingsRepository;

    @Override
    public Shippings saveShipping(Shippings shippings) {
        return shippingsRepository.save(shippings);
    }

    @Override
    public Shippings updateShipping(Shippings shippings) {
        return shippingsRepository.save(shippings);
    }

    @Override
    public void deleteShipping(int id) {
        shippingsRepository.deleteById(id);
    }

    @Override
    public Shippings getShippingById(int id) {
        Optional<Shippings> optionalShippings = shippingsRepository.findById(id);
        return optionalShippings.orElse(null);
    }

    @Override
    public List<Shippings> getAllShippings() {
        return shippingsRepository.findAll();
    }
}
