package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactUpdateService;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/contactservice/v1")
public class ContactUpdateController {

    @Autowired
    ContactUpdateService contactUpdateService;

    @RequestMapping(value = "/contacts/{email}/name/firstName/{firstName}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> updateFistName(@PathVariable String email,
                                            @PathVariable String firstName) {
        ContactDto contactDto = null;
        contactDto = contactUpdateService.updateFirstName(email, firstName);
        if (contactDto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contactDto);
    }
}
