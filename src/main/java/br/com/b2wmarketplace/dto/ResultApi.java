package br.com.b2wmarketplace.dto;

import java.util.List;

public class ResultApi {

	private List<PlanetaApiFilms> results;
	private String next;
	private String previous;
	
	
	@Override
	public String toString() {
		return "ResultApi [results=" + results + ", next=" + next + ", previous=" + previous + "]";
	}
	public List<PlanetaApiFilms> getResults() {
		return results;
	}
	public void setResults(List<PlanetaApiFilms> results) {
		this.results = results;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}


	
}
