package com.moriartynho.apilocaisderisco;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.locais.services.LocalService;

@SpringBootApplication
public class ApiLocaisDeRiscoApplication implements CommandLineRunner {

	private LocalService localService;
	
	  public ApiLocaisDeRiscoApplication(LocalService localService) {
	        this.localService = localService;
	    }

	public static void main(String[] args) {
		SpringApplication.run(ApiLocaisDeRiscoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Local l1 = new Local(null, "Rua do Gravatá, 320, Jardim Marina, Itapevi, São Paulo", "Enchente",
				LocalDateTime.now());
		Local l2 = new Local(null, "Rua das Samambaias, 36, Jardim Marina, Itapevi, São Paulo", "Enchente",
				LocalDateTime.now());
		Local l3 = new Local(null, "Rua Jean Ramos, 7, Jardim Marina, Itapevi, São Paulo", "Enchente",
				LocalDateTime.now());
		Local l4 = new Local(null, "Rua da Portuguesa, 300, Vila Santa Rita, Itapevi, São Paulo", "Enchente",
				LocalDateTime.now());

		Arrays.asList(l1, l2, l3, l4).forEach(x -> {
			try {
				localService.inserirLocal(x);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		;

	}

}
