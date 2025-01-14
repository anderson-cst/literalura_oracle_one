package com.anderson.cst.literalura.config;

import com.anderson.cst.literalura.Model.Book;

public interface IConvert {
    <T> T convertFromJson(String json, Class<T> clazz);

}
