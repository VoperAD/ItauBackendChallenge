package dev.voper.itauchallenge.service;

import dev.voper.itauchallenge.dto.TransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TransactionService {

    private static final Map<UUID, TransactionDto> TRANSACTIONS = new HashMap<>();

    public void createTransaction(@Validated TransactionDto transactionDto) {
        TRANSACTIONS.put(UUID.randomUUID(), transactionDto);
    }

    public void deleteTransactions() {
        TRANSACTIONS.clear();
    }

}
