package com.gb.contactmanagement.contactmanagement.service;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto save(ContactDto contactDto);
    ContactDto findById(String emailId);
    List<Contact> findByName(String name);
    List<Contact> findByGender(String gender);
}
