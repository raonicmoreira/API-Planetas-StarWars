package br.com.b2wmarketplace.dto;

import br.com.b2wmarketplace.modelo.Planeta;

//class Data Transfer Object de Planetas
public class PlanetaDTO {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	public PlanetaDTO() {
	}
	
	public PlanetaDTO(Planeta obj) {
		id = obj.getId();
		nome = obj.getNome();
		clima = obj.getClima();
		terreno = obj.getTerreno();
	}
	
	public Planeta fromDTO(PlanetaDTO objDto) {
		return new Planeta(objDto.getId(), objDto.getNome(), objDto.getClima(), objDto.getTerreno());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	
	
}
