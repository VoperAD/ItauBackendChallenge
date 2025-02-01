package dev.voper.itauchallenge.controller;

import dev.voper.itauchallenge.dto.TransactionDto;
import dev.voper.itauchallenge.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
    }

}
