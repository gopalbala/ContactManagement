package com.gb.contactmanagement.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gb.contactmanagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactDto {
    private String emailId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Salutation salutation;
    private short age;
    private List<Address> addressList;
    private Phone phone;
    private ZonedDateTime zonedDateTime;
    private List<String> friends;

    public ContactDto(Contact contact) {
        this.emailId = contact.getEmailId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.middleName = contact.getMiddleName();
        this.gender = contact.getGender();
        this.salutation = contact.getSalutation();
        this.age = contact.getAge();
        this.addressList = contact.getAddressList();
        this.phone = contact.getPhone();
        this.friends = contact.getFriends();
    }
}
