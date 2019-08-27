package com.fernando.cursomc.services.excepitions;

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
