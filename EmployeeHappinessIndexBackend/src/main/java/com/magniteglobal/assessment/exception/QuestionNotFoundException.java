package com.magniteglobal.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuestionNotFoundException(String message) {
		super(message);
	}
}