package dpawleta.restapi.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String body = ex.getMessage();
        log.warn(body);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The data you provided violates a foreign key constraint.");
    }

    @ExceptionHandler(IllegalJsonBodyException.class)
    public ResponseEntity<String> handleIllegalJsonBodyException(IllegalJsonBodyException ex) {
        String body = ex.getMessage();
        log.warn(body);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add comment with a specified id. Please delete id row.");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        String body = ex.getMessage();
        log.warn(body);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find provided id.");
    }
}