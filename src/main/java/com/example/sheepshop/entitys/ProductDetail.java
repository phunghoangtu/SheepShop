package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collar_style_id" , referencedColumnName = "id")
    private CollarStyle collarStyle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hand_style_id" , referencedColumnName = "id")
    private HandStyle handStyle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id" , referencedColumnName = "id")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id" , referencedColumnName = "id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id" , referencedColumnName = "id")
    private Material material;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;


}