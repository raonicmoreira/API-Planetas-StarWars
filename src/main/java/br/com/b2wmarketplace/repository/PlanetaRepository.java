package br.com.b2wmarketplace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.b2wmarketplace.modelo.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String>{


}
