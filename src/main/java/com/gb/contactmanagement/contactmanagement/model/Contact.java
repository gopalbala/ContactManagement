package com.gb.contactmanagement.contactmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "contacts")
@TypeAlias("contact")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    @Id
    String emailId;
    @Field("firstName")
    String firstName;
    @Field("middleName")
    String middleName;
    @Field("lastName")
    String lastName;
    @Field
    String fullName;
    @Field("gender")
    Gender gender;
    @Field("salutation")
    Salutation salutation;
    @Field("age")
    short age;

    public Contact(ContactDto contactDto) {
        this.emailId = contactDto.getEmailId();
        this.firstName = contactDto.getFirstName();
        this.lastName = contactDto.getLastName();
        this.middleName = contactDto.getMiddleName();
        this.fullName = getFullName(contactDto.getFirstName(), contactDto.getMiddleName(), contactDto.getLastName());
        this.gender = contactDto.getGender();
        this.salutation = contactDto.getSalutation();
        this.age = contactDto.getAge();
    }

    private String getFullName(String firstName, String middleName, String lastName) {
        return firstName + middleName == null ? StringUtils.EMPTY : " " + middleName + lastName == null ? StringUtils.EMPTY : " " + lastName;
    }
}
