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
@Table(name = "jewelrymetals")
public class JewelryMetals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jewelryid")
    private int jewelryId; // khoa phu

    @Column(name = "metalpriceid")
    private int metalPriceId; //khoa phu

    @Column(name ="Weight")
    private BigDecimal weight;

}
