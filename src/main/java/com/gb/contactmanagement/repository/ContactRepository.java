package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    //114010100223966 utib0000114
    List<Contact> findByFirstNameLike(String firstName);
    List<Contact> findByLastNameLike(String lastName);

    List<Contact> findByFullNameLike(String name);
    List<Contact> findByFullNameStartingWith(String name);
    List<Contact> findByFullNameEndingWith(String name);
    List<Contact> findByFullNameContaining(String name);
    List<Contact> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);

    List<Contact> findByAgeGreaterThan(int age);

    List<Contact> findByAgeLessThan(int age);

    List<Contact> findByAgeBetween(int from, int to);

    List<Contact> findByVerifiedIsTrue();

    List<Contact> findByVerifiedIsFalse();

    List<Contact> findByDateOfBirthAfter(Instant dateTime);

    List<Contact> findByDateOfBirthBefore(Instant dateTime);

    List<Contact> findByDateOfBirthBeforeOrderByDateOfBirth(Instant dateTime);

    //Optional<Contact> save(Contact contact);
}
