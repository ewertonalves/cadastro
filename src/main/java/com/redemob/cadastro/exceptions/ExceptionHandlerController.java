package com.redemob.cadastro.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redemob.cadastro.model.response.MessageResponse;


@RestControllerAdvice
public class ExceptionHandlerController {

	@Autowired
	private ObjectMapper mapper;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> Exception(Exception exception) throws JsonProcessingException {
		MessageResponse mensagem = new MessageResponse("Erro interno do servidor");
		exception.printStackTrace();
		return new ResponseEntity<String>(mapper.writeValueAsString(mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidConfigurationPropertyValueException.class)
	public ResponseEntity<?> resourceNotFoundException(InvalidConfigurationPropertyValueException exception)
			throws JsonProcessingException {
		MessageResponse mensagem = new MessageResponse(exception.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(mensagem), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> credentialEmptyException(BadRequestException exception)
			throws JsonProcessingException {
		MessageResponse mensagem = new MessageResponse(exception.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(mensagem), HttpStatus.BAD_REQUEST);//400
	}

	@ExceptionHandler(BindException.class) 
	public ResponseEntity<String> bindException(BindException exception) throws JsonProcessingException {
		MessageResponse mensagem = new MessageResponse(exception.getFieldError().getDefaultMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(mensagem), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> methodArgumentNotValidExceptionException(MethodArgumentNotValidException exception)
			throws JsonProcessingException {
		MessageResponse mensagem = new MessageResponse(exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(mensagem), HttpStatus.BAD_REQUEST);
	}
}
