package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.repository.ContactRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public ContactDto save(ContactDto contactDto) {
        return new ContactDto(contactRepository.save(new Contact(contactDto)));
    }

    @Override
    public ContactDto findById(String emailId) {
        Optional<Contact> contact = contactRepository.findById(emailId);
        if (contact.isEmpty())
            return null;
        return new ContactDto(contact.get());
    }

    @Override
    public List<Contact> findByName(String name) {
        return null;
    }

    @Override
    public List<Contact> findByGender(String gender) {
        return null;
    }
}
