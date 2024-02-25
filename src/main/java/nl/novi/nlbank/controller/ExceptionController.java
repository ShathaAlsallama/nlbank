package nl.novi.nlbank.controller;


import nl.novi.nlbank.exeption.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@ControllerAdvice
public class ExceptionController {

    Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {

        logger.warn(exception.getMessage());
        return ResponseEntity.notFound().build();

    }

}