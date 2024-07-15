package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Quotations;
import com.example.swp_jewelryproductionordersystem.repositories.QuotationRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Override
    public Quotations saveQuotation(Quotations quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public Quotations updateQuotation(Quotations quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public void deleteQuotation(int id) {
        quotationRepository.deleteById(id);
    }

    @Override
    public Quotations getQuotationById(int id) {
        Optional<Quotations> optionalQuotation = quotationRepository.findById(id);
        return optionalQuotation.orElse(null);
    }

    @Override
    public List<Quotations> getAllQuotations() {
        return quotationRepository.findAll();
    }
}
