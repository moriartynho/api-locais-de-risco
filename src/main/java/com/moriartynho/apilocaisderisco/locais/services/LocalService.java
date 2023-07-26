package com.moriartynho.apilocaisderisco.locais.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moriartynho.apilocaisderisco.imagem.Imagem;
import com.moriartynho.apilocaisderisco.locais.dto.LocalDTO;
import com.moriartynho.apilocaisderisco.locais.models.Local;
import com.moriartynho.apilocaisderisco.locais.repositories.LocalRepository;
import com.moriartynho.apilocaisderisco.mantimentos.services.ImagemService;
import com.moriartynho.apilocaisderisco.utils.geocode.Geocodificador;

@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private Geocodificador geocodificador;

	@Autowired
	private ImagemService imagemService;

	public Local fromDTO(LocalDTO dto) {
		return new Local(dto.getId(), dto.getEndereco(), dto.getDescricao(), LocalDateTime.now());
	}

	public void inserirLocal(Local local, MultipartFile imagem) throws Exception {
		geocodificador = new Geocodificador();
		Double[] geocode = geocodificador.decodificador(local.getEndereco());
		Imagem img = imagemService.dadosToImagem(imagem);
		local.setLatitude(geocode[0]);
		local.setLongitude(geocode[1]);
		local.setImagem(img);
		localRepository.save(local);
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
		Local local = localRepository.getById(id);
		LocalDTO dto = new LocalDTO(local);
		dto.setImagemId(local.getImagem().getId());
		return dto;
	}

	public void removerLocal(Long id) {
		localRepository.deleteById(id);
	}

	public void editarLocal(Local local) {
		localRepository.save(local);
	}

}
