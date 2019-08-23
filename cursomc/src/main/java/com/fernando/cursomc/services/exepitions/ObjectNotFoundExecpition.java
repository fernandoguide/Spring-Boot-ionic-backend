package com.fernando.cursomc.services.exepitions;

public class ObjectNotFoundExecpition  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExecpition(String msg) {
		super(msg);
	}
	public ObjectNotFoundExecpition (String msg, Throwable cause) {
		super(msg,cause);
	}

}
