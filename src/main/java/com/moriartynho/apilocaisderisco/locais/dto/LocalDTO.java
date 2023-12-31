package com.moriartynho.apilocaisderisco.locais.dto;

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

	private Double latitude;

	private Double longitude;

	private Long imagemId;

	public LocalDTO() {
	}

	public LocalDTO(Local local) {
		BeanUtils.copyProperties(local, this);
		if(local.getImagem().getId() != null) {
			this.imagemId = local.getImagem().getId();
		}
		
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

	public Long getImagemId() {
		return imagemId;
	}

	public void setImagemId(Long imagemId) {
		this.imagemId = imagemId;
	}

}
