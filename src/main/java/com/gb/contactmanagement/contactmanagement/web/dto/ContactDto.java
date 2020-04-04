package com.gb.contactmanagement.contactmanagement.web.dto;

import com.gb.contactmanagement.contactmanagement.model.Gender;
import com.gb.contactmanagement.contactmanagement.model.Salutation;
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
}
