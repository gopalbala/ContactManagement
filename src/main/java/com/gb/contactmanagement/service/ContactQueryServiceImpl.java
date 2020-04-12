package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.repository.ContactQueryRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactQueryServiceImpl implements ContactQueryService {

    private ContactQueryRepository contactQueryRepository;

    public ContactQueryServiceImpl(ContactQueryRepository contactQueryRepository) {
        this.contactQueryRepository = contactQueryRepository;
    }

    @Override
    public List<ContactDto> findByCity(String city) {
        List<Contact> contacts = contactQueryRepository.findByCity(city);
        if (null == contacts || contacts.size() == 0)
            return null;
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }
}
