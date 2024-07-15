package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Quotations;
import com.example.swp_jewelryproductionordersystem.services.interfaces.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping
    public ResponseEntity<Quotations> createQuotation(@RequestBody Quotations quotation) {
        Quotations createdQuotation = quotationService.saveQuotation(quotation);
        return ResponseEntity.ok(createdQuotation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quotations> updateQuotation(@PathVariable int id, @RequestBody Quotations quotation) {
        quotation.setId(id);
        Quotations updatedQuotation = quotationService.updateQuotation(quotation);
        return ResponseEntity.ok(updatedQuotation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable int id) {
        quotationService.deleteQuotation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quotations> getQuotationById(@PathVariable int id) {
        Quotations quotation = quotationService.getQuotationById(id);
        return ResponseEntity.ok(quotation);
    }

    @GetMapping
    public ResponseEntity<List<Quotations>> getAllQuotations() {
        List<Quotations> quotations = quotationService.getAllQuotations();
        return ResponseEntity.ok(quotations);
    }
}