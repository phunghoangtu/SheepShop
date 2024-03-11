package com.example.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", length = 30)
    private String code;

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

    @Column(name = "status")
    private Integer status;

}