package com.dev.cms.service;

import java.util.List;
import java.util.Optional;

import com.dev.cms.model.Contact;

public interface IContactService {

	public List<Contact> getAll();
	
	public Optional<Contact> getById(Long id);

	public Contact add(Contact contact);

	public Contact edit(Contact contact);

	public void delete(Long id);

}
