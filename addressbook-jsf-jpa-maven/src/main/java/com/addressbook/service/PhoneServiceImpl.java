package com.addressbook.service;

import java.util.List;

import com.addressbook.dao.PhoneDao;
import com.addressbook.dao.PhoneDaoImpl;
import com.addressbook.domain.Phone;

public class PhoneServiceImpl implements PhoneService{

	private PhoneDao phoneDao;
	
	public PhoneServiceImpl() {
		 phoneDao = new PhoneDaoImpl();
	}


	@Override
	public Phone create(Phone p) {
		
		if (p == null) {
			throw new RuntimeException("Model can't be null");
		}
		return this.phoneDao.create(p);
	}

	@Override
	public Phone getById(Long id) {
		
		if (id == null) {
			throw new RuntimeException("Id cannot be null");
		}
		return this.phoneDao.getById(id);
	}

	@Override
	public Phone update(Phone p) {
		
		if (p == null) {
			throw new RuntimeException("Model can't be null");
		}
		return this.phoneDao.update(p);
	}

	@Override
	public void delete(Phone p) {
		
		if (p == null) {
			throw new RuntimeException("Model can't be null");
		}
		this.phoneDao.delete(p);
	}

	@Override
	public List<Phone> getAll() {
		
		return this.phoneDao.getAll();
	}


	@Override
	public List<Phone> findByContactId(Long contactId) {
		return this.phoneDao.findByContactId(contactId);
	}
	
	
	
}
