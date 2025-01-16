package com.anderson.cst.literalura;

import com.anderson.cst.literalura.bookapp.BookApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.anderson.cst.literalura.api.BookAPI.bookAPI;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
		bookAPI();
	}

    @Override
    public void run(String... args) throws Exception {

		BookApp.executar();
    }
}
