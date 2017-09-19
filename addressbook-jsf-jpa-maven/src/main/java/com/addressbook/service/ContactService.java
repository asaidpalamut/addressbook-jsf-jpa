package com.addressbook.service;

import java.util.List;

import com.addressbook.domain.Contact;
import com.addressbook.dto.AddressBookDto;

public interface ContactService {

	Contact create(Contact contact);
	Contact getById(Long id);
	Contact update(Contact contact);
    void delete(Contact contact);
    List<Contact> getAll();
	Contact create(AddressBookDto dto);
	Contact update(AddressBookDto dto);
}
