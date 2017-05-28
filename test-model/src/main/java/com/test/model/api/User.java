package com.test.model.api;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Usuário on 26/05/2017.
 */
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "javax.validation.constraint.user.name.NotNull")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "javax.validation.constraint.user.email.NotNull")
    @Pattern(regexp = "^(.+)@(.+)$",
            message = "javax.validation.constraint.user.email.Pattern")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "javax.validation.constraint.user.phone.NotNull")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull(message = "javax.validation.constraint.user.sex.NotNull")
    @Column(name = "sex", nullable = false)
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
