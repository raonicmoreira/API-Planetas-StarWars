package br.com.b2wmarketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2wmarketplace.modelo.Planeta;
import br.com.b2wmarketplace.repository.PlanetaRepository;
import br.com.b2wmarketplace.service.exception.ObjectNotFoundException;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	
	// busca todos os planetas no banco de dados
	public List<Planeta> findAll(){
		return repository.findAll();
	}
	
	// buscar planeta por ID
	public Planeta findById(String id) {
		Optional<Planeta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
