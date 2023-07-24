package com.moriartynho.apilocaisderisco.utils.geocode;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GeocodeResponse {
	private String status;
	private List<GeocodeResult> results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<GeocodeResult> getResults() {
		return results;
	}

	public void setResults(List<GeocodeResult> results) {
		this.results = results;
	}

}
