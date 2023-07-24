package com.moriartynho.apilocaisderisco.mantimentos.dto;

import org.springframework.beans.BeanUtils;

import com.moriartynho.apilocaisderisco.mantimentos.models.PontoDeMantimentos;

public class PontoDeMantimentosDTO {

	private Long id;
	private String endereco;
	private String latitude;

	private String longitude;

	public PontoDeMantimentosDTO() {
	}

	public PontoDeMantimentosDTO(PontoDeMantimentos ponto) {
		BeanUtils.copyProperties(ponto, this);
	}

	public PontoDeMantimentosDTO(Long id, String endereco, String latitude, String longitude) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



}
