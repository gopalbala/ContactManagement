package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto save(ContactDto contactDto);
    ContactDto findById(String emailId);
    List<ContactDto> findByFirstName(String firstName);
    List<ContactDto> findByName(String name);
    List<ContactDto> findByNameStartingWith(String name);
    List<ContactDto> findByNameEndingWith(String name);
    List<ContactDto> findByGender(String gender);
    List<ContactDto> findByAgeGreaterThan(int age);
    List<ContactDto> findByAgeLessThan(int age);
    List<ContactDto> findByAgeBetween(int from,int to);
    List<ContactDto> findByVerified(boolean verified);
}
