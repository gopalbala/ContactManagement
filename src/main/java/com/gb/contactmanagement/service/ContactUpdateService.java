package com.gb.contactmanagement.service;

public interface ContactUpdateService {
    long updateFirstName(String email, String firstName);

    long updateFirstNameMongoTemplate(String email, String firstName);

    long updateVerfiedFlag(String email, boolean verifiedFlag);
}
