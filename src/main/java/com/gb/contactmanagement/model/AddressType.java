package com.gb.contactmanagement.model;

import lombok.Getter;

@Getter
public enum AddressType {
    PERMANENT("permanent"),
    RESIDENT("resident");

    private final String addressType;

    AddressType(String addressTpe) {
        this.addressType = addressTpe;
    }
}
