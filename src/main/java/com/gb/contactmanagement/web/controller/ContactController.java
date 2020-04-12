package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactService;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactservice/v1")
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = {"application/JSON"}, consumes = {"application/JSON"})
    public ResponseEntity<?> addContact(@RequestBody ContactDto contactDto) {
        return new ResponseEntity(contactService.save(contactDto), HttpStatus.OK);
    }


    @RequestMapping(value = "/contacts/name/firstName/{firstName}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByFirstName(@PathVariable String firstName) {
        List<ContactDto> contactDtos = null;
//        contactDtos = contactService.findByFirstName(firstName);
//        if (contactDtos == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(contactDtos, HttpStatus.OK);

        contactDtos = contactService.findByNameStartingWith(firstName);
//        if (contactDtos == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(contactDtos, HttpStatus.OK);

        contactDtos = contactService.findByNameEndingWith(firstName);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/name/{name}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<ContactDto> contactDtos = contactService.findByFirstName(name);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/{emailId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getContactById(@PathVariable String emailId) {
        ContactDto contactDto = contactService.findById(emailId);
        if (contactDto == null)
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity(contactDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/age/{age}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByName(@PathVariable int age) {
//        List<ContactDto> contactDtos = contactService.findByAgeGreaterThan(age);
//        if (contactDtos == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
        List<ContactDto> contactDtos = contactService.findByAgeLessThan(age);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/age/{age1}/{age2}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByName(@PathVariable int age1, @PathVariable int age2) {
//        List<ContactDto> contactDtos = contactService.findByAgeGreaterThan(age);
//        if (contactDtos == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
        List<ContactDto> contactDtos = contactService.findByAgeBetween(age1, age2);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/verified/{isVerified}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getVerifiedContacts(@PathVariable boolean isVerified) {
        List<ContactDto> contactDtos = contactService.findByVerified(isVerified);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }
}
