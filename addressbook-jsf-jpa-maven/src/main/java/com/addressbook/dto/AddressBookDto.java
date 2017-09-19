package com.addressbook.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.addressbook.domain.Address;
import com.addressbook.domain.Phone;

public class AddressBookDto {

	private Long id;
	
	@NotEmpty(message="Name cannot be null!")
	@Pattern(regexp="^[a-zA-Z]+$", message="Invalid name")
	private String name;
	
	@NotEmpty(message="Surname cannot be null!")
	@Pattern(regexp="^[a-zA-Z]+$", message="Invalid surname")
	private String surname;
	
	@Email(message="Invalid email!")
	private String email;
	
	private List<Phone> phones;
	private List<Address> addresses;

	public AddressBookDto() {
		phones = new ArrayList<>();
		addresses = new ArrayList<>();
	}

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
