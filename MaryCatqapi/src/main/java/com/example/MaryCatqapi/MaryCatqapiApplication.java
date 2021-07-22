package com.example.MaryCatqapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class MaryCatqapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaryCatqapiApplication.class, args);

//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//		LocalDate bDate = LocalDate.parse("23/11/2015", formato);
//		LocalDate eDate=LocalDate.parse("23/11/2016", formato);
//		System.out.println(bDate + " && " + eDate);

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("23/11/2015", formato);

		System.out.println(data);
	}

}
