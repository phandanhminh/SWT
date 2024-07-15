package com.example.swp_jewelryproductionordersystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "quotations")
public class Quotations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Totalprice")
    private float totalPrice;

    @Column(name = "Discount")
    private BigDecimal discount;

    @Column(name = "Quotationstatus")
    private String quotationStatus;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Accid")
    private int accId; // khoa phu
}
