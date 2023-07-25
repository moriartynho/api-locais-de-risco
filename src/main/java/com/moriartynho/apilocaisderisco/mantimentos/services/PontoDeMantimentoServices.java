package com.moriartynho.apilocaisderisco.mantimentos.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.apilocaisderisco.mantimentos.dto.PontoDeMantimentosDTO;
import com.moriartynho.apilocaisderisco.mantimentos.models.PontoDeMantimentos;
import com.moriartynho.apilocaisderisco.mantimentos.repositories.PontoDeMantimentosRepository;
import com.moriartynho.apilocaisderisco.utils.geocode.Geocodificador;

@Service
public class PontoDeMantimentoServices {

	@Autowired
	private PontoDeMantimentosRepository pontoRepository;

	@Autowired
	private Geocodificador geocodificador;

	public PontoDeMantimentos fromDTO(PontoDeMantimentosDTO dto) {
		return new PontoDeMantimentos(dto.getId(), dto.getEndereco());
	}

	public void inserirPonto(PontoDeMantimentos ponto) throws IOException {
		geocodificador = new Geocodificador();
		Double[] geocode = geocodificador.decodificador(ponto.getEndereco());
		ponto.setLatitude(geocode[0]);
		ponto.setLongitude(geocode[1]);
		pontoRepository.save(ponto);
	}

	public List<PontoDeMantimentosDTO> todosOsPontos() {
		return pontoRepository.findAll().stream().map(x -> new PontoDeMantimentosDTO(x)).toList();
	}

	@SuppressWarnings("deprecation")
	public PontoDeMantimentosDTO retornaPontoPorId(Long id) {
		return new PontoDeMantimentosDTO(pontoRepository.getById(id));
	}

	public void removerPonto(Long id) {
		pontoRepository.deleteById(id);
	}

}
