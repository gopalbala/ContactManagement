package com.gb.contactmanagement.service;

import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactQueryService {
    List<ContactDto> findByCity(String city);
    List<ContactDto> findByMobile(String mobile);

    List<ContactDto> findByState(String state);

    List<ContactDto> findByFirstNameAndCity(String name, String state);
}
