package com.anderson.cst.literalura.api;

import com.anderson.cst.literalura.dto.BookDTO;
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

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
    private static List<BookDTO> booksDTO;

    public static List<BookDTO> bookAPI() {


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
                booksDTO = objectMapper.readValue(resultsNode.toString(), new TypeReference<List<BookDTO>>() {
                });
                booksDTO.forEach(books -> System.out.println("Book: " + books));
            } else {
                System.out.println("'results' não encontrado ou não é uma array.");
            }
            return booksDTO;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}