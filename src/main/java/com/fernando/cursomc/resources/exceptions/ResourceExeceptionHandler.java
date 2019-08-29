package com.fernando.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernando.cursomc.services.excepitions.AuthorizationException;
import com.fernando.cursomc.services.excepitions.DataIntegrityExecpition;
import com.fernando.cursomc.services.excepitions.ObjectNotFoundExecpition;

@ControllerAdvice
public class ResourceExeceptionHandler {
	
	
	@ExceptionHandler(ObjectNotFoundExecpition.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExecpition e , HttpServletRequest request){
		
		StandardError err = new  StandardError(HttpStatus.NOT_FOUND.value() ,e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ExceptionHandler(DataIntegrityExecpition.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityExecpition e , HttpServletRequest request){
		
		StandardError err = new  StandardError(HttpStatus.BAD_REQUEST.value() ,e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e , HttpServletRequest request){
		
		ValidationError err = new  ValidationError(HttpStatus.BAD_REQUEST.value() ,"Erro de Validação", System.currentTimeMillis());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}

}
