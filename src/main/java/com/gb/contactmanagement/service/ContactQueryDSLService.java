package com.gb.contactmanagement.service;

import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactQueryDSLService {
    List<ContactDto> findByFirstName(String name);

    List<ContactDto> findByState(String state);

    List<ContactDto> findByAgeAndState(int age, String state);

    List<ContactDto> findByAgeBetween(int start, int end);
}
