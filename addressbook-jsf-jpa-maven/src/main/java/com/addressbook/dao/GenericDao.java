package com.addressbook.dao;

import java.util.List;

import com.addressbook.domain.AbstractBaseModel;

public interface GenericDao<T extends AbstractBaseModel> {

	T getById(Long id);
	List<T> getAll();
	T create(T t);
    T update(T t);
    void delete(T t);
}
 