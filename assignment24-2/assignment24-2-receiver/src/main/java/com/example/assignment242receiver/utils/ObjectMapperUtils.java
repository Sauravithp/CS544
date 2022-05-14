package com.example.assignment242receiver.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
