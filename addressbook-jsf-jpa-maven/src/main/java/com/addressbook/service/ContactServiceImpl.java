package com.addressbook.service;

import java.util.List;

import com.addressbook.dao.ContactDao;
import com.addressbook.dao.ContactDaoImpl;
import com.addressbook.domain.Address;
import com.addressbook.domain.Contact;
import com.addressbook.domain.Phone;
import com.addressbook.dto.AddressBookDto;

public class ContactServiceImpl implements ContactService{

	private ContactDao contactDao;
	private AddressService addressService;
	private PhoneService phoneService;
	
	public ContactServiceImpl() {
		contactDao = new ContactDaoImpl();
		addressService = new AddressServiceImpl();
		phoneService = new PhoneServiceImpl();
	}
	
	@Override
	public Contact create(Contact contact) {
		
		if (contact == null) {
			throw new RuntimeException("Model can't be null");
		}
		
		Contact saved = this.contactDao.create(contact);
		if (saved != null) {
			
			Address address = saved.getAddresses().get(0);
			address.setContact(saved);
			addressService.create(address);
			
			for (Phone p : saved.getPhones()) {
				p.setContact(saved);
				phoneService.create(p);
			}
		}
		
		return saved;
	}
	
	
	@Override
	public Contact create(AddressBookDto dto) {
		
		Address address = new Address();
		address.setCity(dto.getAddresses().get(0).getCity());
		address.setCountry(dto.getAddresses().get(0).getCountry());
		
		Contact contact = new Contact();
		contact.setName(dto.getName());
		contact.setSurname(dto.getSurname());
		contact.setEmail(dto.getEmail());
		contact.setPhones(dto.getPhones());
		contact.getAddresses().add(address);
		
		Contact saved = contactDao.create(contact); 
		if (saved != null) {
			address.setContact(saved);
			addressService.create(address);
			for (Phone p : contact.getPhones()) {
				p.setContact(saved);
				phoneService.create(p);
			}
		}
		return saved;
	}

	@Override
	public Contact getById(Long id) {
		
		if (id == null) {
			throw new RuntimeException("Id cannot be null");
		}
		return this.contactDao.getById(id);
	}

	@Override
	public Contact update(Contact contact) {
		
		if (contact == null) {
			throw new RuntimeException("Model can't be null");
		}
		return this.contactDao.update(contact);
	}

	@Override
	public void delete(Contact contact) {
		
		if (contact == null) {
			throw new RuntimeException("Model can't be null");
		}

		List<Phone> phones = phoneService.findByContactId(contact.getId());
		for (Phone phone : phones) {
			phoneService.delete(phone);
		}
		
		List<Address> addresses = addressService.findByContactId(contact.getId());
		for (Address address : addresses) {
			addressService.delete(address);
		}
		
		this.contactDao.delete(contact);
	}

	@Override
	public List<Contact> getAll() {
		
		return this.contactDao.getAll();
	}

	@Override
	public Contact update(AddressBookDto dto) {

		Contact updated = getById(dto.getId());
		
		if (updated != null) {
			updated.setName(dto.getName());
			updated.setSurname(dto.getSurname());
			updated.setEmail(dto.getEmail());
			updated.setAddresses(dto.getAddresses());
			updated.setPhones(dto.getPhones());
			
			for (Address address : updated.getAddresses()) {
				addressService.update(address);
			}
			
			for (Phone phone : updated.getPhones()) {
				if (phone.getId() == null) {
					phone.setContact(updated);
					phoneService.create(phone);
				}else {
					phoneService.update(phone);
				}
			}
			
			contactDao.update(updated);
			return updated;
		}
		
		return null;
	}

	
}
