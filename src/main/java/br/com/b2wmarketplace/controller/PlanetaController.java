package br.com.b2wmarketplace.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2wmarketplace.dto.PlanetaDTO;
import br.com.b2wmarketplace.modelo.Planeta;
import br.com.b2wmarketplace.service.PlanetaService;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService service;
	
	//metodo para listar todos os planetas cadastrados
	@GetMapping
	public ResponseEntity<List<PlanetaDTO>> listar(){
		List<Planeta> list = service.findAll();
		List<PlanetaDTO> listDto = list.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PlanetaDTO> bucarPorId(@PathVariable String id){
		Planeta obj = service.findById(id);
		
		return ResponseEntity.ok().body(new PlanetaDTO(obj));
	}
}
	
	
	
	
	
