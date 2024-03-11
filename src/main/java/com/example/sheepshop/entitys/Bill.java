package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "total_price_last")
    private Instant totalPriceLast;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "pay_status")
    private Integer payStatus;

    @Column(name = "code_ghn", length = 30)
    private String codeGhn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails;

    @OneToMany(mappedBy = "cart")
    private Set<CartDetail> cartDetails ;

}