package com.anderson.cst.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*@JsonIgnoreProperties(ignoreUnknown = true)*/
public class Author {

    /*@JsonAlias("name")*/
    private String name;
    /*@JsonAlias("birth_year")*/
    private Integer birthYear;
    /*@JsonAlias("death_year")*/
    private Integer DeathYear;

    public Author() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return DeathYear;
    }

    public void setDeathYear(Integer deathYear) {
        DeathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", DeathYear=" + DeathYear +
                '}';
    }
}
