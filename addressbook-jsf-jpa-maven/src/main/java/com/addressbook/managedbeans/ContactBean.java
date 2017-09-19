package com.addressbook.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

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
public class ContactBean {

	private AddressBookDto dto;
	private ContactService contactService;
	private AddressService addressService;
	private PhoneService phoneService;
	
	public ContactBean() {
	}

	@PostConstruct
	public void init() {
		contactService = new ContactServiceImpl();
		addressService = new AddressServiceImpl();
		phoneService = new PhoneServiceImpl();
		
		dto = new AddressBookDto();
		dto.getPhones().add(new Phone());
		dto.getAddresses().add(new Address());
	}

	public AddressBookDto getDto() {
		return dto;
	}

	public void setDto(AddressBookDto dto) {
		this.dto = dto;
	}

	/* Ajax */
	public void onButtonRemovePhoneFieldClick(final Phone p_oField) {
		
		if (p_oField.getId() != null) {
			phoneService.delete(p_oField);
		}
		dto.getPhones().remove(p_oField);
	}

	public void onButtonAddPhoneFieldClick(AjaxBehaviorEvent p_oEvent) {
		dto.getPhones().add(new Phone());
	}
	/* Ajax END */

	public List<Contact> getAll() {
		init();
		return contactService.getAll();
	}

	public String deleteContact(Long id) {

		Contact contact = contactService.getById(id);
		contactService.delete(contact);
		
		return "contactList.xhtml?faces-redirect=true";
	}

	public String createContact() {

		Contact saved = contactService.create(dto);
		if (saved != null) {
			/**
			 * Kayıt Basarılı
			 * yeni işlemler için sayfayı hazirla..
			 */
			init();
			return "contactList.xhtml?faces-redirect=true";
		} else {
			/**
			 * Kayt Basarısız
			 */
			return "newContact.xhtml?faces-redirect=true";
		}

	}
	
	
	public String showDetailsPage() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		Long contactId =  Long.valueOf(params.get("id"));
		
		Contact contact = contactService.getById(contactId);
		List<Address> addresses = addressService.findByContactId(contactId);
		List<Phone> phones = phoneService.findByContactId(contactId);
		
		dto.setId(contact.getId());
		dto.setName(contact.getName());
		dto.setSurname(contact.getSurname());
		dto.setEmail(contact.getEmail());
		dto.setAddresses(addresses);
		dto.setPhones(phones);

		
		return "contactDetails.xhtml?faces-redirect=true&id="+contactId;
	}
	
	
	public String showEditPage() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		Long contactId =  Long.valueOf(params.get("id"));
		
		Contact contact = contactService.getById(contactId);
		List<Address> addresses = addressService.findByContactId(contactId);
		List<Phone> phones = phoneService.findByContactId(contactId);
		
		dto.setId(contact.getId());
		dto.setName(contact.getName());
		dto.setSurname(contact.getSurname());
		dto.setEmail(contact.getEmail());
		dto.setAddresses(addresses);
		dto.setPhones(phones);
		
		return "editContact.xhtml?faces-redirect=true&id="+contactId;
	}
	
	
	public String updateContact() {

		Contact updated = contactService.update(dto);
		if (updated != null) {
			/**
			 * Kayıt Basarılı
			 * yeni işlemler için sayfayı hazirla..
			 */
			init();
			return "contactList.xhtml?faces-redirect=true";
		} else {
			/**
			 * Kayt Basarısız
			 */
			return "editContact.xhtml?faces-redirect=true?id="+updated.getId();
		}

	}
	
	public Contact contactDetails() {
		
		return null;
	}

}
