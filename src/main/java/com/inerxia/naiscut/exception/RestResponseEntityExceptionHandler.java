package com.inerxia.naiscut.exception;

import com.inerxia.naiscut.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<StandardResponse> handleDataNotFound(HttpServletRequest request, DataNotFoundException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataDuplicatedException.class)
    public final ResponseEntity<StandardResponse> handleDataDuplicated(HttpServletRequest request, DataDuplicatedException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataConstraintViolationException.class)
    public final ResponseEntity<StandardResponse> handleDataIntegrityViolation(HttpServletRequest request, DataConstraintViolationException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNoEncontradoException.class)
    public final ResponseEntity<StandardResponse> handleObjectNoEncontrado(HttpServletRequest request, ObjectNoEncontradoException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SedePrincipalExistsException.class)
    public final ResponseEntity<StandardResponse> handleSedePrincipalExists(HttpServletRequest request, SedePrincipalExistsException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RangoInvalidatedException.class)
    public final ResponseEntity<StandardResponse> handleRangoInvalidated(HttpServletRequest request, RangoInvalidatedException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMensaje()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccessDeniedException.class, AutenticationInvalidatedException.class})
    public final ResponseEntity<StandardResponse> handleAccessDeniedException(HttpServletRequest request, AccessDeniedException ex){
        logger.error(request.getContextPath(), ex.toString());
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.EstadoStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.FORBIDDEN);
    }



}
