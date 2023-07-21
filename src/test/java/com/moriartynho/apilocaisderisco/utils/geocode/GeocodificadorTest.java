package com.moriartynho.apilocaisderisco.utils.geocode;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class GeocodificadorTest {
	
	@Autowired
	private Geocodificador geocodificador;
	
	 @BeforeEach
	    public void setUp() {
	        geocodificador = new Geocodificador();
	    }

	@Test
	void deveRetornarLatitudeELongitudeDoEndereco() throws IOException {
		String endereco = "Rua do Gravatá, 320, Jardim Marina, Itapevi, São Paulo";
		String resposta = geocodificador.decodificador(endereco);
	}

}
