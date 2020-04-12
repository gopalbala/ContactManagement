package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactQueryService;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/contactservice/v1/query")
public class ContactQueryController {

    private ContactQueryService contactQueryService;

    public ContactQueryController(ContactQueryService contactQueryService) {
        this.contactQueryService = contactQueryService;
    }

    @RequestMapping(value = "/contacts/city/{city}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByCity(@PathVariable String city) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByCity(city);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/mobile/{mobile}", method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByMobile(@PathVariable String mobile) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByMobile(mobile);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }
}
