package com.lin.imissyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.imissyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.AttributeConverter;

@Component
public class SuperGenericAndJson <T> implements AttributeConverter<T, String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(T t) {
        if (t == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public T convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            T t =  mapper.readValue(s, new TypeReference<T>() {
            });
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
