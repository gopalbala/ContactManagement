package com.gb.contactmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
public class Phone {
    @Field("mobile")
    private String mobile;
    @Field("secondaryMobile")
    private String secondaryMobile;
    @Field("emergencyNumber")
    private String emergencyNumber;
}
