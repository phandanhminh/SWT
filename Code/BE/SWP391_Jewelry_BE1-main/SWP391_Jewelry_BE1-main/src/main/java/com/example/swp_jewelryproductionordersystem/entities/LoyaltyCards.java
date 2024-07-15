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
@Table(name = "LoyaltyCards")
public class LoyaltyCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int cardId;

    @Column(name = "Name")
    private String cardName;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "AccId")
    private int accId; //khoa p
}
