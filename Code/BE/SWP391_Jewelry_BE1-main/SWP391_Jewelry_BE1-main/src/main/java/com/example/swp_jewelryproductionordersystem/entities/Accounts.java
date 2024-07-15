package com.example.swp_jewelryproductionordersystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Deposit")
    private float deposit;

    @Column(name = "Address")
    private String address;

    @Column(name = "Role")
    private String role;

    @Column(name = "Status")
    private int status;


}
