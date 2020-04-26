package com.gb.contactmanagement.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.gb.contactmanagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDto {
    private String emailId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Salutation salutation;
    private short age;
    @JsonProperty("address")
    private List<Address> addressList;
    private Phone phone;
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime dateOfBirth;
    private List<String> friends;
    private List<String> knownLanguages;
    private List<Integer> bodyAttrs;
    private Instant createdDate;
    private Instant updatedDate;

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
        this.dateOfBirth = ZonedDateTime.ofInstant(contact.getDateOfBirth(), ZoneOffset.UTC);
        this.knownLanguages = contact.getKnownLanguages();
        this.bodyAttrs = contact.getBodyAttrs();
        this.createdDate = contact.getCreatedDate();
        this.updatedDate = contact.getUpdatedDate();
    }
}
