package com.addressbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.addressbook.dao.PhoneDao;
import com.addressbook.domain.Phone;
import com.addressbook.util.JPAUtil;

public class PhoneDaoImpl extends GenericDaoImpl<Phone> implements PhoneDao{

	private EntityManager em;
	
	public PhoneDaoImpl() {
		this.em = JPAUtil.geEntityManagerFactory().createEntityManager(); 
	}
	
	@Override
	public List<Phone> findByContactId(Long contactId) {
		TypedQuery<Phone> query = this.em.createQuery("Select p from Phone p where p.contact.id = :contactId", Phone.class)
				.setParameter("contactId", contactId);
		
		return query.getResultList();
	}

}
