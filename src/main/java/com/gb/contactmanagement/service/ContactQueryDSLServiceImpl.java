package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.model.QContact;
import com.gb.contactmanagement.repository.ContactQueryRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
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
        QContact qContact = new QContact("queryByFirstName");
        Predicate firstNamePredicate =
                qContact.firstName.startsWith(firstName);

        QSort sort = QSort.by(QContact.contact.firstName.asc());
        Iterable<Contact> contacts = contactQueryRepository.findAll(firstNamePredicate, sort);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByState(String state) {
        QContact qContact = new QContact("queryBystate");
        Predicate findStatePredicate = qContact.addressList.any().state.startsWith(state);
        QSort sort = QSort.by(QContact.contact.age.asc());
        Iterable<Contact> contacts = contactQueryRepository.findAll(findStatePredicate, sort);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findByAgeAndState(int age, String state) {
        QContact qContact = new QContact("queryByAgeState");
        Predicate findAgePredicate = qContact.age.goe(age);
        Predicate findStatePredicate = qContact.addressList.any().state.startsWith(state);

        Predicate predicate = ((BooleanExpression) findAgePredicate).and(
                findStatePredicate);
        QSort sort = QSort.by(QContact.contact.fullName.asc());
        Iterable<Contact> contacts = contactQueryRepository.findAll(predicate, sort);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());

    }

    @Override
    public List<ContactDto> findByAgeBetween(int start, int end) {
        QContact qContact = new QContact("queryByAgeBetween");
        Predicate findAgeGreaterThan = qContact.age.goe(start);
        Predicate findAgeLessThan = qContact.age.loe(end);
        Predicate predicate =
                ((BooleanExpression) findAgeGreaterThan)
                        .and(findAgeLessThan);

        QSort sort = QSort.by(QContact.contact.age.desc());

        Iterable<Contact> contacts = contactQueryRepository.findAll(predicate, sort);
        if (contacts == null)
            return null;
        return StreamSupport.stream(contacts.spliterator(), true)
                .map(ContactDto::new).collect(Collectors.toList());
    }
}
