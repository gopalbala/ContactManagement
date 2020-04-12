package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByFirstNameLike(String firstName);
    List<Contact> findByFullNameLike(String name);
    List<Contact> findByFullNameStartingWith(String name);
    List<Contact> findByFullNameEndingWith(String name);
    List<Contact> findByAgeGreaterThan(int age);
    List<Contact> findByAgeLessThan(int age);
    List<Contact> findByAgeBetween(int from,int to);
}
