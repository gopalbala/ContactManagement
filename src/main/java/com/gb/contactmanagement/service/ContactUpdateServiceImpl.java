package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.repository.ContactRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactUpdateServiceImpl implements ContactUpdateService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactDto updateFirstName(String email, String firstName) {
        Optional<Contact> contact = contactRepository.findById(email);
        if (!contact.isPresent())
            return null;

        Contact contactToUpdate = contact.get();
        contactToUpdate.setFirstName(firstName);
        String fullName = firstName + (contactToUpdate.getMiddleName() == null
                ? StringUtils.EMPTY : " " + contactToUpdate.getMiddleName())
                + (contactToUpdate.getLastName() == null ?
                StringUtils.EMPTY : " " + contactToUpdate.getLastName());
        contactToUpdate.setFullName(fullName);


        Contact result = contactRepository.save(contactToUpdate);
        return new ContactDto(result);
    }
}
