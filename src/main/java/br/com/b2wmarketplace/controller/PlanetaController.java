package br.com.b2wmarketplace.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.b2wmarketplace.dto.PlanetaDTO;
import br.com.b2wmarketplace.modelo.Planeta;
import br.com.b2wmarketplace.service.PlanetaService;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService service;
	
	//endpoint para listar todos os planetas cadastrados
	@GetMapping
	public ResponseEntity<List<PlanetaDTO>> listar(){
		
		List<Planeta> list = service.findAll();
		// convertendo lista de planeta em lista de planetaDto
		List<PlanetaDTO> listDto = list.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//endpoint para buscar por ID
	@GetMapping(value="/{id}")
	public ResponseEntity<PlanetaDTO> bucarPorId(@PathVariable String id){
		Planeta obj = service.findById(id);
		return ResponseEntity.ok().body(new PlanetaDTO(obj));
	}
	
	//endpoint para inserir Planeta
	@PostMapping
	public ResponseEntity<Void> inserirPlaneta(@RequestBody PlanetaDTO objDto){
		Planeta obj = objDto.fromDTO(objDto);
		obj = service.insert(obj);
		// recuperando caminho do objeto criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//endpoint para deletar planeta
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
	
	
	
	
	
