package com.moriartynho.apilocaisderisco.locais.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moriartynho.apilocaisderisco.imagem.Imagem;
import com.moriartynho.apilocaisderisco.mantimentos.services.ImagemRepository;

@Controller
@CrossOrigin("*")
public class ImagemController {

	@Autowired
	private ImagemRepository imagemRepository;

	@GetMapping("/imagem/{id}")
	public ResponseEntity<byte[]> exibirImagem(@PathVariable Long id) {
		Imagem imagem = imagemRepository.findById(id).orElse(null);
		if (imagem != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl("max-age=3600");
			headers.setContentType(MediaType.IMAGE_JPEG); 
			return new ResponseEntity<>(imagem.getDados(), headers, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
