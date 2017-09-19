package com.addressbook.dao;

import java.util.List;

import com.addressbook.domain.Phone;

public interface PhoneDao extends GenericDao<Phone>{

	List<Phone> findByContactId(Long contactId);

}
