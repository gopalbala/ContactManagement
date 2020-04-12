package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ContactQueryRepository extends MongoRepository<Contact, String> {
    @Query("{'address.city':{$regex: '^?0'}}")
    List<Contact> findByCity(String city);
}
