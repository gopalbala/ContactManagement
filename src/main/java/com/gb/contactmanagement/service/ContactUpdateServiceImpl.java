package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.repository.ContactRepository;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class ContactUpdateServiceImpl implements ContactUpdateService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updateFirstName(String email, String firstName) {
        Optional<Contact> contact = contactRepository.findById(email);
        if (!contact.isPresent())
            return -1;

        Contact contactToUpdate = contact.get();
        contactToUpdate.setFirstName(firstName);
        String fullName = firstName + (contactToUpdate.getMiddleName() == null
                ? StringUtils.EMPTY : " " + contactToUpdate.getMiddleName())
                + (contactToUpdate.getLastName() == null ?
                StringUtils.EMPTY : " " + contactToUpdate.getLastName());
        contactToUpdate.setFullName(fullName);

        Contact result = contactRepository.save(contactToUpdate);
        return 1;
    }

    @Override
    public long updateFirstNameMongoTemplate(String email, String firstName) {
        Contact contact =
                mongoTemplate.findOne(new Query(where("_id").is(email)), Contact.class);

        String fullName = firstName + (contact.getMiddleName() == null
                ? StringUtils.EMPTY : " " + contact.getMiddleName())
                + (contact.getLastName() == null ?
                StringUtils.EMPTY : " " + contact.getLastName());
        contact.setFullName(fullName);

        Query query = new Query(where("_id").is(email));
        Update conToUpdate = new Update();
        conToUpdate.set("firstName", firstName);
        conToUpdate.set("fullName", fullName);

        UpdateResult updateResult =
                mongoTemplate.updateFirst(query, conToUpdate, Contact.class);
        return updateResult.getModifiedCount();
    }
}
