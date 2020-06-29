package br.com.b2wmarketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2wmarketplace.dto.ResultApi;
import br.com.b2wmarketplace.modelo.Planeta;
import br.com.b2wmarketplace.repository.PlanetaRepository;
import br.com.b2wmarketplace.service.exception.ObjectNotFoundException;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	
	final static String url = "https://swapi.dev/api/planets/?search=";
	   
    RestTemplate restTemplate = new RestTemplate();
	
	// busca todos os planetas no banco de dados
	public List<Planeta> findAll(){
		return repository.findAll();
	}
	
	// buscar planeta por ID
	public Planeta findById(String id) {
		Optional<Planeta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	// buscar planeta por nome
	public List<Planeta> findByNome(String nome) {
		
		Optional<List<Planeta>> obj = repository.findByNomeLikeIgnoreCase(nome);
		if(obj.get().isEmpty()){
			System.out.println("objeto não encontrado");
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return obj.get();
	}
	
	
	// inserir planeta no banco de dados
	public Planeta insert(Planeta obj) {
		Integer quantidadeFilmes = consultarFilmeStarWars(obj.getNome());
		obj.setQuantidadeAparicoesEmFilmes(quantidadeFilmes);
		return repository.insert(obj);
	}
	
	// deletar planeta do bando de dados
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	// Consultando numero de filmes em que o planeta apareceu
	private Integer consultarFilmeStarWars(String name) {
		Integer qtFilmes;
	
			ResponseEntity<ResultApi> exchange = restTemplate.exchange(url+name,HttpMethod.GET, null, ResultApi.class);
			if(exchange.getBody().getResults() == null) {
				return qtFilmes = 0;
			}
			List<String> filmes = exchange.getBody().getResults().get(0).getFilms();
			qtFilmes = filmes.size();
			return qtFilmes;
		
	}
	
}
