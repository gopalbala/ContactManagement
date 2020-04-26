package com.gb.contactmanagement.service;

import com.gb.contactmanagement.web.dto.ContactDto;

public interface ContactUpdateService {
    ContactDto updateFirstName(String email, String firstName);
}
