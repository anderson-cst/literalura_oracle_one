package com.anderson.cst.literalura.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JacksonConvert implements IConvert {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ObjectMapper getMapper() {
        return MAPPER;
    }

    @Override
    public <T> List<T> convertFromJsonToList(String json, TypeReference<List<T>> typeReference) {
        try {
            return MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
            throw new RuntimeException("Não foi possível converter o JSON para a lista " + typeReference.getType(), e);
        }
    }

    @Override
    public <T> T convertFromJson(String json, Class<T> clazz) {
    return null;
/*        try {
            JsonNode node = MAPPER.readTree(json);
            JsonNode resultsNode = node.get("results");
            if (resultsNode != null && resultsNode.isArray()) {
                List<Book> books = new ArrayList<>();
                for (JsonNode bookNode : resultsNode) {
                    Book book = new Book();
                    JsonNode titleNode = bookNode.get("title");
                    if (titleNode != null) {
                        book.setTitle(titleNode.asText());
                    }
                    JsonNode downloadCountNode = bookNode.get("download_count");
                    if (downloadCountNode != null) {
                        book.setDownloadCount(downloadCountNode.asInt());
                    }
                    JsonNode authorsNode = bookNode.get("authors");
                    if (authorsNode != null && authorsNode.isArray()) {
                        List<Author> authors = new ArrayList<>();
                        for (JsonNode authorNode : authorsNode) {
                            Author author = new Author();
                            JsonNode nameNode = authorNode.get("name");
                            if (nameNode != null) {
                                author.setName(nameNode.asText());
                            }
                            JsonNode birthYearNode = authorNode.get("birth_year");
                            if (birthYearNode != null) {
                                author.setBirthYear(birthYearNode.asInt());
                            }
                            JsonNode deathYearNode = authorNode.get("death_year");
                            if (deathYearNode != null) {
                                author.setDeathYear(deathYearNode.asInt());
                            }
                            authors.add(author);
                        }
                        book.setAuthors(authors);
                    }
                    JsonNode languagesNode = bookNode.get("languages");
                    if (languagesNode != null && languagesNode.isArray()) {
                        List<String> languages = new ArrayList<>();
                        for (JsonNode languageNode : languagesNode) {
                            languages.add(languageNode.asText());
                        }
                        book.setLanguages(languages);
                    }
                    books.add(book);
                }
                return (T) books;
            } else {
                throw new RuntimeException("Estrutura JSON inesperada: 'results' não encontrado");
            }
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
            throw new RuntimeException("Não foi possível converter o JSON para a classe " + clazz.getName(), e);
        }*/



        /*try {
            JsonNode node = MAPPER.readTree(json);
            // Exemplo de lógica de parsing adicional

            JsonNode bookNode = node.get("results"); // ajustando conforme necessário
            String title = bookNode.get("title").toString();
            int downloadCount = bookNode.get("download_count").asInt();

            Book book = new Book();
            book.setTitle(title);
            book.setDownloadCount(downloadCount);

            // Parse authors
            JsonNode authorsNode = bookNode.get("authors");
                for (JsonNode authorNode : authorsNode) {
                    Author author = new Author();
                    author.setName(authorNode.get("name").asText());
                    author.setBirthYear(authorNode.get("birth_year").asInt());
                    author.setDeathYear(authorNode.get("death_year").isNull() ?
                            null : authorNode.get("death_year").asInt()); book.getAuthors().add(author); }


                // Parse languages
                JsonNode languagesNode = bookNode.get("languages");
                for (JsonNode languageNode : languagesNode) {
                    book.getLanguages().add(languageNode.asText());
                }

                return (T) book;
            } catch (JsonProcessingException e) {
                System.err.println("Error ao processar o JSON: " + e.getMessage());
                throw new RuntimeException("Não foi possível converter o JSON para a classe " + clazz.getName(), e);
        }*/








        /*        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            System.err.println("Error ao processar o JSON: " + e.getMessage());
            throw new RuntimeException("Não foi possível converter o JSON para a classe " + clazz.getName(), e);
        }*/
    }

}
