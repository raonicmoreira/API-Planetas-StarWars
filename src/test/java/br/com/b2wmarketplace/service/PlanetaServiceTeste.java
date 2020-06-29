package br.com.b2wmarketplace.service;


import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.b2wmarketplace.modelo.Planeta;
import br.com.b2wmarketplace.repository.PlanetaRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PlanetaServiceTeste {

	@Autowired
	private PlanetaRepository repo;
	
	
	Planeta planeta = new Planeta("id1", "Tatooine", "temperate", "jungle", 1);
	Planeta planeta1 = new Planeta("id2", "Dorin", "tropical", "rainforests", 3);
   
	
	@Test
	public void teste_insert() {
	    
		Planeta planeta = repo.save(new Planeta("Mon Cala","tropical", "rainforests",2));
	    Assert.assertFalse(planeta.getId().isEmpty());
	    repo.delete(planeta);
	}

	 
	@Test
	public void teste_buscarPorNome() {
		repo.save(planeta);
		repo.save(planeta1);

		Optional<List<Planeta>> optional = repo.findByNomeLikeIgnoreCase("Tatooine");
    	Assert.assertFalse(optional.get().isEmpty());
	}
	
	@Test
    public void teste_buscarPorId() {
    	
		Optional<Planeta> obj = repo.findById("id1");
    	Assert.assertNotNull(obj);
    	repo.delete(planeta);
    }

	@Test
	public void teste_buscar_todos_planetas() {
	      
	   	List<Planeta> lista = repo.findAll();
	   	Assert.assertFalse(lista.isEmpty());
	}
	
	@Test
    public void teste_delete() {
    	
    	Optional<List<Planeta>> optional = repo.findByNomeLikeIgnoreCase("Dorin");
    	repo.delete(optional.get().get(0));
    	Optional<List<Planeta>> optionalResult = repo.findByNomeLikeIgnoreCase("Dorin");
    	Assert.assertTrue(optionalResult.get().isEmpty());

    	Assert.assertFalse(optional.get().isEmpty());
    	 
    }
	
	@Test
	public void testa_consultarFilmeStarWars() {
		Integer aparicoes = new PlanetaService().consultarFilmeStarWars("Tatooine");
		Assert.assertTrue(aparicoes == 5);
	}
}
