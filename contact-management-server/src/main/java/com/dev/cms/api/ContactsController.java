package com.dev.cms.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.cms.model.Contact;
import com.dev.cms.service.IContactService;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactsController {

	private IContactService contactService;

	public ContactsController(IContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping
	public ResponseEntity<List<Contact>> getAll() {
		try {
			List<Contact> contacts = contactService.getAll();
			return new ResponseEntity<>(contacts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Contact> getById(@PathVariable("id") Long id) {
		Optional<Contact> contact = contactService.getById(id);
		if (contact.isPresent()) {
			return new ResponseEntity<>(contact.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
		try {
			Contact newContact = contactService.add(contact);
			return new ResponseEntity<>(newContact, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
		try {
			Contact updatedContact = contactService.edit(contact);
			return new ResponseEntity<>(updatedContact, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
		try {
			contactService.delete(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
