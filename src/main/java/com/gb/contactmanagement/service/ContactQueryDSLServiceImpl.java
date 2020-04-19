package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.model.QContact;
import com.gb.contactmanagement.repository.ContactQueryRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContactQueryDSLServiceImpl implements ContactQueryDSLService {
    @Autowired
    ContactQueryRepository contactQueryRepository;

    @Override
    public List<ContactDto> findByFirstName(String firstName) {
        QContact qContact = new QContact("queryByName");
        Predicate firstNamePredicate =
                qContact.firstName.startsWith(firstName);

        Iterable<Contact> contacts = contactQueryRepository.findAll(firstNamePredicate);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByState(String state) {
        QContact qContact = new QContact("queryBystate");
        Predicate findStatePredicate = qContact.addressList.any().state.startsWith(state);
        Iterable<Contact> contacts = contactQueryRepository.findAll(findStatePredicate);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());
    }
}
