package com.addressbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.addressbook.dao.AddressDao;
import com.addressbook.domain.Address;
import com.addressbook.util.JPAUtil;

public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

	private EntityManager em;

	public AddressDaoImpl() {
		this.em = JPAUtil.geEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<Address> findByContactId(Long contactId) {
		TypedQuery<Address> query = this.em.createQuery("Select a from Address a where a.contact.id = :contactId", Address.class)
				.setParameter("contactId", contactId);
		
		return query.getResultList();
	}

}
