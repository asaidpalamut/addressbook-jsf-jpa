package com.addressbook.managedbeans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.addressbook.domain.Address;
import com.addressbook.domain.Contact;
import com.addressbook.domain.Phone;
import com.addressbook.dto.AddressBookDto;
import com.addressbook.service.AddressService;
import com.addressbook.service.AddressServiceImpl;
import com.addressbook.service.ContactService;
import com.addressbook.service.ContactServiceImpl;
import com.addressbook.service.PhoneService;
import com.addressbook.service.PhoneServiceImpl;

@ManagedBean
@SessionScoped
public class AddressBean {

	private Address address;
	private AddressBookDto dto;

	private ContactService contactService;
	private AddressService addressService;
	private PhoneService phoneService;

	public AddressBean() {
	}

	@PostConstruct
	public void init() {
		contactService = new ContactServiceImpl();
		addressService = new AddressServiceImpl();
		phoneService = new PhoneServiceImpl();

		dto = new AddressBookDto();
		address = new Address();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressBookDto getDto() {
		return dto;
	}

	public void setDto(AddressBookDto dto) {
		this.dto = dto;
	}

	public String showNewAddressPage() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		Long contactId = Long.valueOf(params.get("id"));

		Contact contact = contactService.getById(contactId);
		List<Address> addresses = addressService.findByContactId(contactId);
		List<Phone> phones = phoneService.findByContactId(contactId);

		dto.setId(contact.getId());
		dto.setName(contact.getName());
		dto.setSurname(contact.getSurname());
		dto.setEmail(contact.getEmail());
		dto.setAddresses(addresses);
		dto.setPhones(phones);

		return "newAddress.xhtml?faces-redirect=true&id=" + contactId;
	}

	public String createAddressForContact() {

		Contact contact = contactService.getById(dto.getId());
		address.setContact(contact);
		contact.getAddresses().add(address);
		addressService.create(address);
		init();

		return "contactList.xhtml?faces-redirect=true";
	}

}
