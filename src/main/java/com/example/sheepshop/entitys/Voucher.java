package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 30)
    private String code;

    @Nationalized
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "type_voucher")
    private Boolean typeVoucher;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "Cash")
    private BigDecimal cash;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status")
    private Integer status;

}