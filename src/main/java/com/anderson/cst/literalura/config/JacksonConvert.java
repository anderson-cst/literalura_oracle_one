package com.anderson.cst.literalura.config;

import com.anderson.cst.literalura.Model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConvert implements IConvert {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ObjectMapper getMapper() {
        return MAPPER;
    }

    @Override
    public <T> T convertFromJson(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            System.err.println("Error ao processar o JSON: " + e.getMessage());
            throw new RuntimeException("Não foi possível converter o JSON para a classe " + clazz.getName(), e);
        }
    }
}
