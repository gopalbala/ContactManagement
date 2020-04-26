package com.gb.contactmanagement.service;

import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactUpdateService {
    long updateFirstName(String email, String firstName);

    long updateFirstNameMongoTemplate(String email, String firstName);

    long updateVerifiedFlag(String email, boolean verifiedFlag);

    long updatePhone(String email, String phone);

    long updateLanguage(String email, String language);

    long updateLanguages(String email, List<String> languages);

    long updateAge(String email, int age);

    long updateLanguageToSet(String email, String language);

    long updateVerifiedFlagByState(String state, boolean verifiedFlag);

    long upsert(ContactDto contactDto);
}
