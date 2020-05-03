package com.gb.contactmanagement.repository;

import com.gb.contactmanagement.model.Contact;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ContactEntityBeforeConvertCallback implements BeforeConvertCallback<Contact>, Ordered {
    @Override
    public Contact onBeforeConvert(Contact entity, String collection) {
        if (collection.equalsIgnoreCase("contacts")) {
            entity.setFullName(getFullName(entity.getFirstName(),
                    entity.getMiddleName(), entity.getLastName()));
        }
        return entity;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    private String getFullName(String firstName, String middleName, String lastName) {
        String fullName = firstName + (middleName == null ? StringUtils.EMPTY : " " + middleName) + (lastName == null ? StringUtils.EMPTY : " " + lastName);
        return fullName;
    }
}
