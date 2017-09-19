package com.addressbook.service;

import java.util.List;

import com.addressbook.domain.Phone;

public interface PhoneService{

	Phone create(Phone p);
	Phone getById(Long id);
	Phone update(Phone p);
    void delete(Phone p);
    List<Phone> getAll();
	List<Phone> findByContactId(Long contactId);
}
