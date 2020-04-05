package com.gb.contactmanagement.contactmanagement.web.controller;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import com.gb.contactmanagement.contactmanagement.service.ContactService;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/contactservice/v1")
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = {"application/JSON"}, consumes = {"application/JSON"})
    public ResponseEntity<?> addContact(@RequestBody ContactDto contactDto) {
        return new ResponseEntity(contactService.save(contactDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/{emailId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getContactById(@PathVariable String emailId) {
        if (contactService.findById(emailId) == null)
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity(contactService.findById(emailId), HttpStatus.OK);
    }
}
