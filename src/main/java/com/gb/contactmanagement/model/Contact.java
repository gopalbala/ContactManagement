package com.gb.contactmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gb.contactmanagement.web.dto.ContactDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "contacts")
@TypeAlias("contact")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    @Id
    private String emailId;
    @Field("firstName")
    private String firstName;
    @Field("middleName")
    private String middleName;
    @Field("lastName")
    private String lastName;
    @Field
    private String fullName;
    @Field("gender")
    private Gender gender;
    @Field("salutation")
    private Salutation salutation;
    @Field("age")
    private short age;
    @Field("address")
    private List<Address> addressList;
    @Field("phone")
    private Phone phone;
    @Field("friends")
    private List<String> friends;
    @Field("verified")
    private boolean verified;

    public Contact(ContactDto contactDto) {
        this.emailId = contactDto.getEmailId();
        this.firstName = contactDto.getFirstName();
        this.lastName = contactDto.getLastName();
        this.middleName = contactDto.getMiddleName();
        this.fullName = getFullName(contactDto.getFirstName(), contactDto.getMiddleName(), contactDto.getLastName());
        this.gender = contactDto.getGender();
        this.salutation = contactDto.getSalutation();
        this.age = contactDto.getAge();
        this.addressList = contactDto.getAddressList();
        this.phone = contactDto.getPhone();
        this.verified = false;
    }

    private String getFullName(String firstName, String middleName, String lastName) {
        String fullName = firstName + (middleName == null ? StringUtils.EMPTY : " " + middleName) + (lastName == null ? StringUtils.EMPTY : " " + lastName);
        return fullName;
    }
}
