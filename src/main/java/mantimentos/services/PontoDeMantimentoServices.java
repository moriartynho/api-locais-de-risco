package mantimentos.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.apilocaisderisco.utils.geocode.Geocodificador;

import mantimentos.dto.PontoDeMantimentosDTO;
import mantimentos.models.PontoDeMantimentos;
import mantimentos.repositories.PontoDeMantimentosRepository;

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
		String geocode = geocodificador.decodificador(ponto.getEndereco());
		ponto.setGeocode(geocode);
		pontoRepository.save(ponto);
	}

	public List<PontoDeMantimentosDTO> todosOsPontos() {
		return pontoRepository.findAll().stream().map(x -> new PontoDeMantimentosDTO(x)).toList();
	}

	public PontoDeMantimentosDTO retornaPontoPorId(Long id) {
		return new PontoDeMantimentosDTO(pontoRepository.getById(id));
	}

	public void removerPonto(Long id) {
		pontoRepository.deleteById(id);
	}

}
