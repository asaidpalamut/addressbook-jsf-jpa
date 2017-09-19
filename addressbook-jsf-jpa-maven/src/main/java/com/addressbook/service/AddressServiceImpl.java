package com.addressbook.service;

import java.util.List;

import com.addressbook.dao.AddressDao;
import com.addressbook.dao.AddressDaoImpl;
import com.addressbook.domain.Address;

public class AddressServiceImpl implements AddressService{

	private AddressDao addressDao;
	
	public AddressServiceImpl() {
		addressDao = new AddressDaoImpl();
	}
	
	@Override
	public Address create(Address address) {
		
		if (address == null) {
			throw new RuntimeException("Model can't be null");
		}
		return this.addressDao.create(address);
	}

	@Override
	public Address getById(Long id) {
		
		if (id == null) {
			throw new RuntimeException("Id cannot be null");
		}
		return this.addressDao.getById(id);
	}

	@Override
	public Address update(Address address) {
		
		if (address == null) {
			throw new RuntimeException("Model can't be null");
		}
		return this.addressDao.update(address);
	}

	@Override
	public void delete(Address address) {
		
		if (address == null) {
			throw new RuntimeException("Model can't be null");
		}
		this.addressDao.delete(address);
	}

	@Override
	public List<Address> getAll() {
		
		return this.addressDao.getAll();
	}

	@Override
	public List<Address> findByContactId(Long contactId) {
		return this.addressDao.findByContactId(contactId);
	}
}
