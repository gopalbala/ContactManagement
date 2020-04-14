package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.repository.ContactRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ContactDto> findByFirstName(String firstName) {
        List<Contact> contacts = contactRepository.findByFirstNameLike(firstName);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByLastName(String lastName) {
        List<Contact> contacts = contactRepository.findByLastNameLike(lastName);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByName(String name) {
        List<Contact> contacts = contactRepository.findByFullNameLike(name);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByNameStartingWith(String name) {
        List<Contact> contacts = contactRepository.findByFullNameStartingWith(name);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByNameEndingWith(String name) {
        List<Contact> contacts = contactRepository.findByFullNameEndingWith(name);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByFirstNameLikeOrLastNameLike(String name) {
        List<Contact> contacts = contactRepository.findByFirstNameLikeOrLastNameLike(name, name);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByGender(String gender) {
        return null;
    }

    @Override
    public List<ContactDto> findByAgeGreaterThan(int age) {
        List<Contact> contacts = contactRepository.findByAgeGreaterThan(age);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByAgeLessThan(int age) {
        List<Contact> contacts = contactRepository.findByAgeLessThan(age);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByAgeBetween(int from, int to) {
        List<Contact> contacts = contactRepository.findByAgeBetween(from, to);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByVerified(boolean verified) {
        List<Contact> contacts = null;
        if (verified) {
            contacts =  contactRepository.findByVerifiedIsTrue();
        } else {
            contacts = contactRepository.findByVerifiedIsFalse();
        }
        if (contacts == null || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByDateOfBirthAfter(Instant date) {
        List<Contact> contacts = contactRepository.findByDateOfBirthAfter(date);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByDateOfBirthBefore(Instant date) {
        List<Contact> contacts = contactRepository.findByDateOfBirthBefore(date);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByDateOfBirthBeforeSortByDateOfBirthDesc(Instant date) {
        List<Contact> contacts = contactRepository.findByDateOfBirthBeforeOrderByDateOfBirth(date);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByFullNameContaining(String name) {
        List<Contact> contacts = contactRepository.findByFullNameContaining(name);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }
}
