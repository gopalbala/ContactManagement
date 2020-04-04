package com.gb.contactmanagement.contactmanagement.service;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact save(ContactDto contactDto);
    Optional<Contact> findById(String emailId);
    List<Contact> findByName(String name);
    List<Contact> findByGender(String gender);
}
