package com.addressbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact extends AbstractBaseModel {

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "surname")
	@NotNull
	private String surname;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "contact")
	private List<Phone> phones;

	@OneToMany(mappedBy = "contact")
	private List<Address> addresses;

	public Contact() {
		phones = new ArrayList<>();
		addresses = new ArrayList<>();
	}

	public Contact(String name, String surname, String email, List<Phone> phones, List<Address> addresses) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phones = phones;
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
