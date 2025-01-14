package com.anderson.cst.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.anderson.cst.literalura.api.BookAPI.bookAPI;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
		bookAPI();
	}

}
