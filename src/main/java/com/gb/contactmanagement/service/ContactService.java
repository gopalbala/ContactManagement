package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto save(ContactDto contactDto);
    ContactDto findById(String emailId);
    List<Contact> findByName(String name);
    List<Contact> findByGender(String gender);
}
