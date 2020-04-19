package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactQueryService;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactservice/v1/query")
public class ContactQueryController {

    private ContactQueryService contactQueryService;

    public ContactQueryController(ContactQueryService contactQueryService) {
        this.contactQueryService = contactQueryService;
    }

    @RequestMapping(value = "/contacts/city/{city}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByCity(@PathVariable String city) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByCity(city);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/mobile/{mobile}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByMobile(@PathVariable String mobile) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByMobile(mobile);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/state/{state}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByState(@PathVariable String state) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByState(state);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/name/{name}/city/{city}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByFirstNameAndCity(@PathVariable String name, @PathVariable String city) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByFirstNameAndCity(name, city);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/knownLanguage/{knownLanguage}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getbyKnownLanguage(@PathVariable String knownLanguage) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByKnownLanguage(knownLanguage);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/knownLanguages",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getbyKnownLanguages(@RequestParam(name = "knownLanguages")
                                                         List<String> knownLanguages) {
        List<ContactDto> contactDtos = null;

        if (knownLanguages == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (knownLanguages.size() < 2)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (knownLanguages.size() > 2)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        contactDtos = contactQueryService.findByKnownLanguages(knownLanguages.get(0),
                knownLanguages.get(1));

        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/height/{height}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getByWeights(@PathVariable int height) {
        List<ContactDto> contactDtos = null;
        contactDtos = contactQueryService.findByHeight(height);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/secondaryNumber/{secondaryNumber}",
            method = RequestMethod.GET, produces = {"application/JSON"})
    public ResponseEntity<?> getBySecondaryNumber(@PathVariable String secondaryNumber) {
        List<ContactDto> contactDtos = null;
        if (StringUtils.isBlank(StringUtils.trim(secondaryNumber)))
            secondaryNumber = null;
        contactDtos = contactQueryService.findBySeconaryMobile(secondaryNumber);
        if (contactDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }
}
