package br.com.b2wmarketplace.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
	
	//endpoint para listar por id, nome ou todos os planetas cadastrados
	@GetMapping
	public List<PlanetaDTO> listar(String id, String nome){
		
		List<PlanetaDTO> listDTO = new ArrayList<>();
		
		if(id != null) {
			Planeta obj = service.findById(id);
			listDTO.add(new PlanetaDTO(obj));
			return listDTO;
		}
		if(nome != null) {
			List<Planeta> obj = service.findByNome(nome);
			listDTO = obj.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
			return listDTO;
		}
		List<Planeta> list = service.findAll();
		
		// convertendo lista de planeta em lista de planetaDto
		listDTO = list.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
		
		return listDTO;
	}
	
	
	//endpoint para inserir Planeta
	@PostMapping
	public ResponseEntity<Void> inserirPlaneta(@RequestBody @Valid PlanetaDTO objDto){
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
	
	
	
	
	
