package com.addressbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "phone")
public class Phone extends AbstractBaseModel {

	@Column(name = "phoneNumber")
	@Pattern(regexp="^[0-9]*$", message="Only numeric character!")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;

	public Phone() {
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
