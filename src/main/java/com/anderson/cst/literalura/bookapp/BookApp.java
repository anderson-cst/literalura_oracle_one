package com.anderson.cst.literalura.bookapp;

import com.anderson.cst.literalura.api.BookAPI;
import com.anderson.cst.literalura.dto.BookDTO;
import com.anderson.cst.literalura.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class BookApp {


    public static void executar() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            exibirMenu();
            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    /*listarLivrosRegistrados();*/
                    break;
                case 3:
                    /*istarAutoresRegistrados();*/
                    break;
                case 4:
                    /*listarAutoresVivos();*/
                    break;
                case 5:
                    /*listarAutoresVivosRefinado();*/
                    break;
                case 6:
                    /*listarAutoresPorAnoDeMorte();*/
                    break;
                case 7:
                    /*listarLivrosPorIdioma();*/
                    break;
                case 0:
                    System.out.println("Encerrando a LiterAlura!");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void searchBookByTitle() {

        Scanner scanner = new Scanner(System.in);
        List<BookDTO> books = BookAPI.bookAPI();
        System.out.print("Digite o título do livro: ");
        String title = scanner.nextLine();
        books.stream()
                .filter(book -> book.title().equalsIgnoreCase(title))
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.println("Livro encontrado: " + book),
                        () -> System.out.println("Livro não encontrado.")
                );
    }

    private static void exibirMenu() {
        System.out.println("""
                ===========================================================
                                    LITERALURA
                       Uma aplicação para você que gosta de livros !
                       Escolha um número no menu abaixo:
                -----------------------------------------------------------
                                     Menu
                           1- Buscar livros pelo título
                           2- Listar livros registrados
                           3- Listar autores registrados
                           4- Listar autores vivos em um determinado ano
                           5- Listar autores nascidos em determinado ano
                           6- Listar autores por ano de sua morte
                           7- Listar livros em um determinado idioma
                           0- Sair
                """);
    }
}
