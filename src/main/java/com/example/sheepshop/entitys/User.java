package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 30)
    private String code;

    @Nationalized
    @Column(name = "fullname", length = 100)
    private String fullname;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 256)
    private String password;

    @Lob
    @Column(name = "image")
    private String image;

    @Column(name = "gender")
    private Long gender;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new LinkedHashSet<>();

}