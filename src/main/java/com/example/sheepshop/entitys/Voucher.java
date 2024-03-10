package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", length = 30)
    private String code;

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

    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new LinkedHashSet<>();

}