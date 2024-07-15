package com.example.swp_jewelryproductionordersystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Orderdetailid")
    private int orderDetailId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Createdate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createDate;

    @Column(name = "Detailstatus")
    private String detailStatus;

    @Column(name = "Jewelryid")
    private int jewelryId; //khoa p
    @Column(name = "Orderid")
    private int orderId;
}
