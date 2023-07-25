package com.moriartynho.apilocaisderisco.mantimentos.dto;

import org.springframework.beans.BeanUtils;

import com.moriartynho.apilocaisderisco.mantimentos.models.PontoDeMantimentos;

public class PontoDeMantimentosDTO {

	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;

	public PontoDeMantimentosDTO() {
	}

	public PontoDeMantimentosDTO(PontoDeMantimentos ponto) {
		BeanUtils.copyProperties(ponto, this);
	}

	public PontoDeMantimentosDTO(Long id, String endereco, Double latitude, Double longitude) {
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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
