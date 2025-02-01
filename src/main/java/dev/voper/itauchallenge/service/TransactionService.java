package dev.voper.itauchallenge.service;

import dev.voper.itauchallenge.dto.TransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.OffsetDateTime;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.List;
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

    public List<TransactionDto> getLatestTransactions(TemporalAmount temporalAmount) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime offsetDateTime = now.minus(temporalAmount);

        return TRANSACTIONS.values().stream()
                .filter(t -> {
                    OffsetDateTime dateTime = t.dateTime();
                    return dateTime.isBefore(now) && dateTime.isAfter(offsetDateTime);
                })
                .toList();
    }

}
