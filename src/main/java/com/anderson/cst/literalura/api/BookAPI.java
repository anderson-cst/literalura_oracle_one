package com.anderson.cst.literalura.api;

import com.anderson.cst.literalura.Model.Book;
import com.anderson.cst.literalura.config.JacksonConvert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BookAPI {

    static JacksonConvert jacksonConvert = new JacksonConvert();
    static Book book = new Book();

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    public static void bookAPI() {
        String endereco = "https://gutendex.com/books";

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> resp;


        try {
            resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta recebida: " + resp.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fazendo Consumo...");
        String json = resp.body();
        System.out.println("Resposta JSON: " + json);
        System.out.printf(String.valueOf("Resposta OBJ: " + book));


        JsonNode jsonBooks;
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
    }

}
