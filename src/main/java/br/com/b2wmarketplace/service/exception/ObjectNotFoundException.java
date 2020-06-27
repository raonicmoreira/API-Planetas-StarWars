package br.com.b2wmarketplace.service.exception;

// classe para tratar erro caso o id não exista
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
