package br.com.b2wmarketplace.dto;

import br.com.b2wmarketplace.modelo.Planeta;

//class Data Transfer Object de Planetas
public class PlanetaDTO {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer quantidadeAparicoesEmFilmes;
	
	public PlanetaDTO() {
	}
	
	public PlanetaDTO(Planeta obj) {
		id = obj.getId();
		nome = obj.getNome();
		clima = obj.getClima();
		terreno = obj.getTerreno();
		quantidadeAparicoesEmFilmes = obj.getQuantidadeAparicoesEmFilmes();
	}
	
	public Planeta fromDTO(PlanetaDTO objDto) {
		return new Planeta(objDto.getId(), objDto.getNome(), objDto.getClima(), objDto.getTerreno(), objDto.getQuantidadeAparicoesEmFilmes());
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

	public Integer getQuantidadeAparicoesEmFilmes() {
		return quantidadeAparicoesEmFilmes;
	}

	public void setQuantidadeAparicoesEmFilmes(Integer quantidadeAparicoesEmFilmes) {
		this.quantidadeAparicoesEmFilmes = quantidadeAparicoesEmFilmes;
	}

	
	
}
