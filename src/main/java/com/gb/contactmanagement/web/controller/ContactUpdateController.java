package com.gb.contactmanagement.web.controller;

import com.gb.contactmanagement.service.ContactUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactservice/v1")
public class ContactUpdateController {

    @Autowired
    ContactUpdateService contactUpdateService;

    @RequestMapping(value = "/contacts/{email}/name/firstName/{firstName}",
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updateFirstName(@PathVariable String email,
                                             @PathVariable String firstName) {

        long updatedCount = contactUpdateService.updateFirstNameMongoTemplate(email, firstName);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }

    @RequestMapping(value = "/contacts/{email}/verified/{verifiedFlag}",
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updateVerifiedFlag(@PathVariable String email,
                                                @PathVariable boolean verifiedFlag) {

        long updatedCount = contactUpdateService.updateVerifiedFlag(email, verifiedFlag);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }

    @RequestMapping(value = "/contacts/{email}/phone/{phone}",
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updatePhone(@PathVariable String email,
                                         @PathVariable String phone) {

        long updatedCount = contactUpdateService.updatePhone(email, phone);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }

    @RequestMapping(value = "/contacts/{email}/language/{language}",
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updateLanguage(@PathVariable String email,
                                            @PathVariable String language) {

        long updatedCount = contactUpdateService.updateLanguage(email, language);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }

    @RequestMapping(value = "/contacts/{email}/languages",
            method = RequestMethod.PUT, produces = {"application/JSON"})
    public ResponseEntity<?> updateLanguages(@PathVariable String email,
                                             @RequestParam("languages") List<String> languages) {

        long updatedCount = contactUpdateService.updateLanguages(email, languages);
        if (updatedCount == -1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCount);
    }
}
