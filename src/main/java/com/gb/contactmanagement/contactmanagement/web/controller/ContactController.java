package com.gb.contactmanagement.contactmanagement.web.controller;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import com.gb.contactmanagement.contactmanagement.service.ContactService;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/contactservice/v1")
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = {"application/JSON"}, consumes = {"application/JSON"})
    public Contact addContact(@RequestBody ContactDto contactDto) {
        return contactService.save(contactDto);
    }
}
