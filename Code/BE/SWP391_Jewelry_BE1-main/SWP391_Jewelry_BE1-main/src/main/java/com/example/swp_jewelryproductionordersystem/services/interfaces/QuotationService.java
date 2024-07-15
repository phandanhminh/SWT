package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Quotations;

import java.util.List;

public interface QuotationService {
    Quotations saveQuotation(Quotations quotation);
    Quotations updateQuotation(Quotations quotation);
    void deleteQuotation(int id);
    Quotations getQuotationById(int id);
    List<Quotations> getAllQuotations();
}
