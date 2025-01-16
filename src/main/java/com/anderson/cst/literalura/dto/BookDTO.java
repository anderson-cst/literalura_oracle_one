package com.anderson.cst.literalura.dto;

import com.anderson.cst.literalura.model.Author;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(@JsonAlias("title") String title,
                      @JsonAlias("authors") List<AuthorDTO> authorsDTO,
                      @JsonAlias("languages") List<String> languages,
                      @JsonAlias("download_count")int downloadCount) {
}
