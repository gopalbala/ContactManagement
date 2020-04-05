package com.gb.contactmanagement.web.dto;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.model.Gender;
import com.gb.contactmanagement.model.Salutation;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    String emailId;
    String firstName;
    String middleName;
    String lastName;
    Gender gender;
    Salutation salutation;
    short age;


    public ContactDto(Contact contact) {
        this.emailId = contact.getEmailId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.middleName = contact.getMiddleName();
        this.gender = contact.getGender();
        this.salutation = contact.getSalutation();
        this.age = contact.getAge();
    }
}
