package com.anderson.cst.literalura.api;

import com.anderson.cst.literalura.Model.Book;
import com.anderson.cst.literalura.config.JacksonConvert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BookAPI {

    private static final String BASE_URL = "https://gutendex.com/books";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static JacksonConvert jacksonConvert = new JacksonConvert();
    static List<Book> book;

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    public static void bookAPI() {


        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

        HttpResponse<String> resp;


        try {
            resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta recebida: " + resp.statusCode());
            String json = resp.body();
            System.out.println("Resposta JSON: " + json);
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode resultsNode = jsonNode.get("results");
            if (resultsNode != null && resultsNode.isArray()) {
                List<Book> books = objectMapper.readValue(resultsNode.toString(), new TypeReference<List<Book>>() {
                });
                books.forEach(book -> System.out.println("Book: " + book));
            } else {
                System.out.println("'results' não encontrado ou não é uma array.");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

/*        JsonNode jsonBooks;
        try {
            jsonBooks = jacksonConvert.getMapper().readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode jsonResults = jsonBooks.get("results");
        if (jsonResults == null) {
            throw new RuntimeException("Campo 'results' não encontrado na resposta JSON.");
        }
        List<Book> books;
        try {
            books = jacksonConvert.getMapper().readerForListOf(Book.class).readValue(jsonResults);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        books.forEach(book -> System.out.println(book.toString()));
        */
    }

}