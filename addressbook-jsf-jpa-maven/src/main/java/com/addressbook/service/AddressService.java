package com.addressbook.service;

import java.util.List;

import com.addressbook.domain.Address;

public interface AddressService {

	Address create(Address address);
	Address getById(Long id);
	Address update(Address address);
    void delete(Address address);
    List<Address> getAll();
	List<Address> findByContactId(Long contactId);
}
