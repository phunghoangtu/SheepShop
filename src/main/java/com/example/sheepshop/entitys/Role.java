package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles = new LinkedHashSet<>();

}