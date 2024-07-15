package com.example.swp_jewelryproductionordersystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="Messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Messageid")
    private int messageId;

    @Column(name = "Message")
    private String message;

    @Column(name = "Image")
    private byte image;

    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date Timestamp;

    @Column(name = "IsRead")
    private boolean isRead;

    @Column(name = "Accid")
    private int accId;
}
