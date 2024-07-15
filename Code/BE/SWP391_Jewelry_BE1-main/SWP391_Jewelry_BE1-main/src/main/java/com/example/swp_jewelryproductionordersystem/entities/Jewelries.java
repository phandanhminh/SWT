package com.example.swp_jewelryproductionordersystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jewelries")
public class Jewelries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Image")
    private byte image;

    @Column(name = "Cost")
    private float cost;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "ChargeId")
    private int chargeId; //khoa phu den dong 43
    @Column(name = "QuotationId")
    private int quotationId;
    @Column(name = "WarehouseId")
    private int warehouseId;
    @Column(name = "SubCateId")
    private String subCateId;
}
