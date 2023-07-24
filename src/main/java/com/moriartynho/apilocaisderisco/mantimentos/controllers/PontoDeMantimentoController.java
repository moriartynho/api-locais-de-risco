package com.moriartynho.apilocaisderisco.mantimentos.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moriartynho.apilocaisderisco.mantimentos.dto.PontoDeMantimentosDTO;
import com.moriartynho.apilocaisderisco.mantimentos.models.PontoDeMantimentos;
import com.moriartynho.apilocaisderisco.mantimentos.services.PontoDeMantimentoServices;

@RestController
@RequestMapping("/pontos")
@CrossOrigin("*")
public class PontoDeMantimentoController {
	
	@Autowired
	private PontoDeMantimentoServices pontoService;
	
	
	@PostMapping
	public ResponseEntity<PontoDeMantimentosDTO> inserirPonto(@RequestBody PontoDeMantimentosDTO dto) throws IOException{
		PontoDeMantimentos ponto = pontoService.fromDTO(dto);
		pontoService.inserirPonto(ponto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PontoDeMantimentosDTO>> retornaTodosOsPontos(){
		List<PontoDeMantimentosDTO> depoimentos = pontoService.todosOsPontos();
		return ResponseEntity.ok().body(depoimentos);
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<PontoDeMantimentosDTO> retornaUmPonto(@PathVariable Long id){
		PontoDeMantimentosDTO dto = pontoService.retornaPontoPorId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<PontoDeMantimentosDTO> editaUmPonto(@PathVariable Long id, @RequestBody PontoDeMantimentosDTO dto) throws IOException{
		PontoDeMantimentos ponto = pontoService.fromDTO(dto);
		pontoService.inserirPonto(ponto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path ="/{id}")
	public ResponseEntity<PontoDeMantimentosDTO> deletaUmPonto(@PathVariable Long id){
		pontoService.removerPonto(id);
		return ResponseEntity.ok().build();
	}

}
