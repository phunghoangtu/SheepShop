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
@Table(name = "collar_style")
public class CollarStyle {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", length = 50)
    private String name;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "collarStyle")
    private Set<ProductDetail> productDetails;

}