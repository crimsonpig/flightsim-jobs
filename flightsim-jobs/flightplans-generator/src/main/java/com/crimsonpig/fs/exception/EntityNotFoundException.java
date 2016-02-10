package com.crimsonpig.fs.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 288331429570208980L;

	private String title;
	
	public EntityNotFoundException(String title){
		this.title = title;
	}
	
	@Override
	public String getMessage(){
		return "Entity : " + title + " not found in database! ";
	}
}
