package com.dev.cms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.cms.model.Contact;
import com.dev.cms.repository.IContactRepository;
import com.dev.cms.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {
	
	private IContactRepository contactRepository;

	public ContactServiceImpl(IContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getById(Long id) {
		return contactRepository.findById(id);
	}
	
	public Contact add(Contact contact) {
		return contactRepository.save(contact);
	}

	public Contact edit(Contact contact) {
		return contactRepository.save(contact);
	}

	public void delete(Long id) {
		contactRepository.deleteById(id);
	}
}
