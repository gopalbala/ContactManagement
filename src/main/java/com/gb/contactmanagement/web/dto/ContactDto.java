package com.gb.contactmanagement.web.dto;

import com.gb.contactmanagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

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
    @Field("address")
    private List<Address> addressList;
    @Field("phone")
    private Phone phone;

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
