package com.addressbook.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.addressbook.dao.GenericDao;
import com.addressbook.domain.AbstractBaseModel;
import com.addressbook.util.JPAUtil;

public class GenericDaoImpl<T extends AbstractBaseModel> implements GenericDao<T> {

	public Class<T> clazz;
	public EntityManager em;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		this.em = JPAUtil.geEntityManagerFactory().createEntityManager();
	}

	public T getById(Long id) {

		return this.em.find(clazz, id);
	}

	public List<T> getAll() {

		TypedQuery<T> query = this.em.createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
		return query.getResultList();
	}

	public T create(T t) {

		this.em.getTransaction().begin();
		this.em.persist(t);
		this.em.getTransaction().commit();

		return t;
	}

	public T update(T t) {

		this.em.getTransaction().begin();
		t = this.em.merge(t);
		this.em.getTransaction().commit();

		return t;
	}

	public void delete(T t) {

		this.em.getTransaction().begin();
		t = this.em.merge(t);
		this.em.remove(t);
		this.em.getTransaction().commit();
	}

}
