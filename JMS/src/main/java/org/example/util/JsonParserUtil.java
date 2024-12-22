package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T parseJson(String json, Class<T> valueType) throws Exception {
        return objectMapper.readValue(json, valueType);
    }
}
