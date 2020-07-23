package com.inerxia.naiscut.exception;

import com.inerxia.naiscut.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<StandardResponse> handleEntityNotFound(HttpServletRequest request, EntityNotFoundException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.NOT_FOUND);
    }

}
