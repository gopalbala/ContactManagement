package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.bson.Document;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

@Component
public class ContactEntityBeforeSaveCallback implements BeforeSaveCallback<Contact>, Ordered {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Contact onBeforeSave(Contact entity, Document document, String collection) {
        if (collection.equalsIgnoreCase("contacts")) {
            document.append("encrypted", false);
        }
        return entity;
    }
}
