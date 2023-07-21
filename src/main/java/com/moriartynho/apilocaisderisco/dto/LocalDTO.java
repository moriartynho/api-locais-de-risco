package com.moriartynho.apilocaisderisco.dto;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moriartynho.apilocaisderisco.locais.models.Local;

public class LocalDTO {

	private Long id;

	private String endereco;

	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;

	private String geocode;

	public LocalDTO() {
	}

	public LocalDTO(Local local) {
		BeanUtils.copyProperties(local, this);
	}

	public LocalDTO(Long id, String endereco, String descricao, LocalDateTime data) {
		this.id = id;
		this.endereco = endereco;
		this.descricao = descricao;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getGeocode() {
		return geocode;
	}

	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}
	
	

}
