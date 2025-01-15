package com.anderson.cst.literalura.config;

import com.anderson.cst.literalura.Model.Book;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public interface IConvert {
    <T> T convertFromJson(String json, Class<T> clazz);
    <T> List<T> convertFromJsonToList(String json, TypeReference<List<T>> typeReference);
}
