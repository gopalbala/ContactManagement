package com.gb.contactmanagement.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZonedDateTime;

@Component
@WritingConverter
public class ZonedDateTimeToWriteConverter implements Converter<ZonedDateTime, Instant> {
    @Override
    public Instant convert(ZonedDateTime source) {
        return source.toInstant();
    }
}
