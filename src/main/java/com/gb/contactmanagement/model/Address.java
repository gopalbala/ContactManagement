package com.gb.contactmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
public class Address {
    @Field
    private String addressLine1;
    @Field
    private String addressLine2;
    @Field
    private String addressLine3;
    @Field
    private String city;
    @Field
    private String state;
    @Field
    private String country;
    @Field
    private String zipCode;
    @Field
    private AddressType addressType;
}
