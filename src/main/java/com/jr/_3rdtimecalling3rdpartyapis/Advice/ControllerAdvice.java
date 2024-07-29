package com.jr._3rdtimecalling3rdpartyapis.Advice;

import com.jr._3rdtimecalling3rdpartyapis.DTO.ErrorDTO;
import com.jr._3rdtimecalling3rdpartyapis.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

// inside this you should have all the exceptions
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
