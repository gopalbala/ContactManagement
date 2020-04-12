package com.gb.contactmanagement.config;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeReadConverter implements Converter<Instant, ZonedDateTime> {
    @Override
    public ZonedDateTime convert(Instant source) {
        return ZonedDateTime.ofInstant(source, ZoneOffset.UTC);
    }
}
