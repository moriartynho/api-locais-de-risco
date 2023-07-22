package mantimentos.dto;

import org.springframework.beans.BeanUtils;

import mantimentos.models.PontoDeMantimentos;

public class PontoDeMantimentosDTO {

	private Long id;
	private String endereco;
	private String geocode;

	public PontoDeMantimentosDTO() {
	}

	public PontoDeMantimentosDTO(PontoDeMantimentos ponto) {
		BeanUtils.copyProperties(ponto, this);
	}

	public PontoDeMantimentosDTO(Long id, String endereco, String geocode) {
		this.id = id;
		this.endereco = endereco;
		this.geocode = geocode;
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

	public String getGeocode() {
		return geocode;
	}

	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

}
