package com.example.cryptoxcnange.controller.traderController;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.role.Trader;
import com.example.cryptoxcnange.repositrory.traderRepository.TraderRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.traderService.TraderService;
import com.example.cryptoxcnange.util.TraderErrorResponse;
import com.example.cryptoxcnange.util.TraderNotCreatedException;
import com.example.cryptoxcnange.util.TraderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trader")
@AllArgsConstructor
public class TraderController {
    private final TraderService traderService;
    private final CurrencyService currencyService;
    private final TraderRepository traderRepository;

    @GetMapping
    public List<Trader> getAllTraders() {
        return traderService.getAllTraders();
    }


    @GetMapping("/{id}")
    public Trader getTraderByID(@PathVariable("id") int id) {
        return traderService.getTraderByID(id);

    }


    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createNewTrader(@RequestBody
                                                      Trader trader,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //todo
            StringBuilder builder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
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

    @PatchMapping("/{id}/update")
    public ResponseEntity<HttpStatus> updateTrader(@RequestBody Trader traderToUpdate, @PathVariable
    int id) {
        var trader = traderService.getTraderByID(id);
        trader.setUserName(traderToUpdate.getUserName());
        trader.setEmail(traderToUpdate.getEmail());
        trader.setCurrencyList(traderToUpdate.getCurrencyList());
        traderRepository.save(trader);
        return ResponseEntity.ok(HttpStatus.OK);

    }


    @GetMapping("/curr")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @ExceptionHandler
    public ResponseEntity<TraderErrorResponse> handleException(TraderNotCreatedException e) {
        TraderErrorResponse response = new TraderErrorResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<TraderErrorResponse> handleException(TraderNotFoundException e) {
        TraderErrorResponse errorResponse = new TraderErrorResponse(
                "Trader id not found", System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
