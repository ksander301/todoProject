package ru.test.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component

public class String2LocaleDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {

        if (source == null) {
            return null;
        }
        return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
