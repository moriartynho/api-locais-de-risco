package com.moriartynho.apilocaisderisco.locais.controllers;

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

import com.moriartynho.apilocaisderisco.locais.dto.LocalDTO;
import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.locais.services.LocalService;



@RestController
@RequestMapping("/locais")
@CrossOrigin("*")
public class LocalController {
	
	
	@Autowired
	private LocalService localService;
	
	
	@PostMapping
	public ResponseEntity<LocalDTO> inserirLocal(@RequestBody LocalDTO dto) throws IOException{
		Local depoimento = localService.fromDTO(dto);
		localService.inserirLocal(depoimento);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<LocalDTO>> retornaTodosOsLocais(){
		List<LocalDTO> depoimentos = localService.todosOsLocais();
		return ResponseEntity.ok().body(depoimentos);
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<LocalDTO> retornaUmLocal(@PathVariable Long id){
		LocalDTO dto = localService.retornaLocalPorId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<LocalDTO> editaUmLocal(@PathVariable Long id, @RequestBody LocalDTO dto) throws IOException{
		Local depoimento = localService.fromDTO(dto);
		localService.inserirLocal(depoimento);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path ="/{id}")
	public ResponseEntity<LocalDTO> deletaUmLocal(@PathVariable Long id){
		localService.removerLocal(id);
		return ResponseEntity.ok().build();
	}

}
