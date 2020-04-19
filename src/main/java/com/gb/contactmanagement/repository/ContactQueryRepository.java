package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ContactQueryRepository
        extends MongoRepository<Contact, String>,
        QuerydslPredicateExecutor<Contact> {

    @Query("{'address.city':{$regex: '^?0'}}")
    List<Contact> findByCity(String city);

    @Query(value = "{'phone.mobile':{$regex: '^?0'}}", sort = "{ age: -1 }")
    List<Contact> findByMobile(String mobile);

    @Query(value = "{'address.state': {$regex: '^?0'}}", sort = "{firstName: 1}")
    List<Contact> findByState(String state);

    @Query(value = "{$and:[{'firstName':{$regex:'^?0'}},{'address.city':{$regex: '^?1'}}]}")
    List<Contact> findByFirstNameAndCity(String name, String city);

    @Query(value = "{'knownLanguages':'?0'}")
    List<Contact> findByKnownLanguage(String knownLanguage);

    @Query(value = "{'knownLanguages':{ $all:['?0','?1']}}")
    List<Contact> findByKnownLanguages(String lang1, String lang2);

    @Query(value = "{bodyAttrs: {$gt: ?0}}")
    List<Contact> findByHeight(int height);

    @Query(value = "{'phone.secondaryMobile': null}")
    List<Contact> findBySeconaryMobile(String seondaryMobile);

}
