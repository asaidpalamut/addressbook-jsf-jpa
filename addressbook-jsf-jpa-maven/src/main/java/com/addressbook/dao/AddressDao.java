package com.addressbook.dao;

import java.util.List;

import com.addressbook.domain.Address;

public interface AddressDao extends GenericDao<Address>{

	List<Address> findByContactId(Long contactId);

}
