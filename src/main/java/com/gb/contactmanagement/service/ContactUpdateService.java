package com.gb.contactmanagement.service;

public interface ContactUpdateService {
    long updateFirstName(String email, String firstName);

    long updateFirstNameMongoTemplate(String email, String firstName);

    long updateVerifiedFlag(String email, boolean verifiedFlag);

    long updatePhone(String email, String phone);

    long updateLanguage(String email, String language);
}
