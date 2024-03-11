package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", length = 30)
    private String code;

    @Nationalized
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "product")
    private Set<ProductDetail> productDetails;

}