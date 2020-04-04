package com.gb.contactmanagement.contactmanagement.repository;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
