package com.dev.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.cms.model.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {

	/*
	 * public List<Contact> getAll();
	 * 
	 * public int add(Contact contact);
	 * 
	 * public Contact edit(Contact contact);
	 * 
	 * public boolean delete(int id);
	 */
}
