package com.moriartynho.apilocaisderisco.locais.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.apilocaisderisco.locais.dto.LocalDTO;
import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.locais.repositories.LocalRepository;
import com.moriartynho.apilocaisderisco.utils.geocode.Geocodificador;

@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private Geocodificador geocodificador;

	public Local fromDTO(LocalDTO dto) {
		return new Local(dto.getId(), dto.getEndereco(), dto.getDescricao(), dto.getData());
	}

	public void inserirLocal(Local local) throws IOException {
		geocodificador = new Geocodificador();
		Double[] geocode = geocodificador.decodificador(local.getEndereco());
		local.setLatitude(geocode[0]);
		local.setLongitude(geocode[1]);
		localRepository.save(local);
	}

	public List<LocalDTO> todosOsLocais() {
		return localRepository.findAll().stream().map(x -> new LocalDTO(x)).toList();
	}

	@SuppressWarnings("deprecation")
	public LocalDTO retornaLocalPorId(Long id) {
		return new LocalDTO(localRepository.getById(id));
	}

	public void removerLocal(Long id) {
		localRepository.deleteById(id);
	}

}