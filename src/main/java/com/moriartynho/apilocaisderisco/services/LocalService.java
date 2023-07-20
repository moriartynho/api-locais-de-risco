package com.moriartynho.apilocaisderisco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.apilocaisderisco.dto.LocalDTO;
import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.repositories.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository localRepository;

	public Local fromDTO(LocalDTO dto) {
		return new Local(dto.getId(), dto.getEndereco(), dto.getDescricao(), dto.getData());
	}

	public void inserirLocal(Local depoimento) {
		localRepository.save(depoimento);
	}

	public List<LocalDTO> todosOsLocais() {
		return localRepository.findAll().stream().map(x -> new LocalDTO(x)).toList();
	}

	public LocalDTO retornaLocalPorId(Long id) {
		return new LocalDTO(localRepository.getById(id));
	}

	public void removerLocal(Long id) {
		localRepository.deleteById(id);
	}

}
