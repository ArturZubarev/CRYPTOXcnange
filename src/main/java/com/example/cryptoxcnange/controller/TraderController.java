package com.example.cryptoxcnange.controller;

import com.example.cryptoxcnange.model.role.Trader;
import com.example.cryptoxcnange.service.TraderService;
import com.example.cryptoxcnange.util.TraderErrorResponse;
import com.example.cryptoxcnange.util.TraderNotCreatedException;
import com.example.cryptoxcnange.util.TraderNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trader")
@AllArgsConstructor
public class TraderController {
    private final TraderService traderService;

    @GetMapping()
    public List<Trader> getAllTraders(){
        return traderService.getAllTraders();
    }

    @GetMapping("/trader/{id}")
    public Trader getTraderByID(@PathVariable("id") int id){
        return traderService.getTraderByID(id);

    }

    @ExceptionHandler
    public ResponseEntity<TraderErrorResponse> handleException(TraderNotFoundException e){
        TraderErrorResponse errorResponse = new TraderErrorResponse(
                "Trader id not found", System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createNewTrader(@RequestBody
                                                           Trader trader,
                                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //todo
            StringBuilder builder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                builder.append(error.getField())
                        .append("-")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

            throw new TraderNotCreatedException("Trader not create");
        }
        traderService.save(trader);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<TraderErrorResponse> handleException(TraderNotCreatedException e){
        TraderErrorResponse response = new TraderErrorResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
