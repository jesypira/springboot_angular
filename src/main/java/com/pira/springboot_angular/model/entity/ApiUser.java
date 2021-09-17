package com.pira.springboot_angular.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(unique = true, name="login")
    @NotEmpty(message = "{field.login.required}")
    private String username;

    @Column(name="password")
    @NotEmpty(message = "{field.password.required}")
    private String password;

}
