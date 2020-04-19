package com.gb.contactmanagement.service;

import com.gb.contactmanagement.web.dto.ContactDto;

import java.util.List;

public interface ContactQueryDSLService {
    public List<ContactDto> findByFirstName(String name);
}
