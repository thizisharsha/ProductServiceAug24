package com.example.ProductServiceAug24.advice;

import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<String> getproductNotFoundException(productNotFoundException e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }
}
