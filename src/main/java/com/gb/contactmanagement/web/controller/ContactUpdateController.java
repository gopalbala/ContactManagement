package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactUpdateService;
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
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updateFistName(@PathVariable String email,
                                            @PathVariable String firstName) {

        long updatedCount = contactUpdateService.updateFirstNameMongoTemplate(email, firstName);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }
}
