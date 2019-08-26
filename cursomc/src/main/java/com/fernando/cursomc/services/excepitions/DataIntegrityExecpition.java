package com.fernando.cursomc.services.excepitions;

public class DataIntegrityExecpition  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityExecpition(String msg) {
		super(msg);
	}
	public DataIntegrityExecpition (String msg, Throwable cause) {
		super(msg,cause);
	}

}
