package com.moriartynho.apilocaisderisco.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.moriartynho.apilocaisderisco.dto.LocalDTO;
import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.repositories.LocalRepository;

public class LocalService {
	
	@Autowired
	private LocalRepository localRepository;

	public Local fromDTO(LocalDTO dto) {
		return new Local(dto.getId(), dto.getEndereco(), dto.getDescricao(), dto.getData());
	}

	public void inserirLocal(Local depoimento) {
		localRepository.save(depoimento);
	}

}
