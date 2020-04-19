package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactQueryDSLService;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contactservice/v1/dsl")
public class ContactDslController {
    @Autowired
    ContactQueryDSLService contactQueryDSLService;

    @RequestMapping(value = "/contact/firstName/{firstName}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> findByFirstName(@PathVariable String firstName) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryDSLService.findByFirstName(firstName);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/state/{state}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> findByState(@PathVariable String state) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryDSLService.findByState(state);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/age/{age}/state/{state}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> findByAgeAndState(@PathVariable int age, @PathVariable String state) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryDSLService.findByAgeAndState(age, state);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/age/{start}/age/{end}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> findByAgeBetween(@PathVariable int start, @PathVariable int end) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryDSLService.findByAgeBetween(start, end);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

}
