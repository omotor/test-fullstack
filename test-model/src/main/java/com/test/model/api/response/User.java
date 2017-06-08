package com.test.model.api.response;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "User")
public class User implements Serializable {
	public enum SEX {
      MALE, FEMALE, OTHER
    }
	
	private static final long serialVersionUID = -7896345828336572263L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;

	@Column(name="user_name", nullable = false)
	@NotNull(message = "validation.user.name.NotEmpty")
	@Size(min=1, message = "validation.user.name.NotEmpty")
	private String name;
	
	@Column(name="user_email", nullable = false)
	@NotNull(message = "validation.user.email.NotEmpty")
	@Size(min=1,message = "validation.user.email.NotEmpty")
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$",
		message = "validation.user.email.Pattern")
	private String email;
	
	@Column(name="user_telephone", nullable = false)
	@NotNull(message = "validation.user.telephone.NotEmpty")
	@Size(min=1, message = "validation.user.telephone.NotEmpty")
	private String telephone;
	
	@Enumerated(EnumType.STRING)
	@Column(name="user_sex", nullable = false)
	@NotNull(message = "validation.user.sex.NotEmpty")
	private SEX sex;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}
	
}
