package dev.voper.itauchallenge.service;

import dev.voper.itauchallenge.dto.SummaryDto;
import dev.voper.itauchallenge.util.BigDecimalSummaryStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalAmount;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final TransactionService transactionService;

    public SummaryDto getStatistics(TemporalAmount temporalAmount) {
        BigDecimalSummaryStatistics statistics = new BigDecimalSummaryStatistics();

        transactionService.getLatestTransactions(temporalAmount)
                .forEach(t -> {
                    statistics.accept(t.value());
                });

        return new SummaryDto(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAvg(),
                statistics.getMin(),
                statistics.getMax()
        );
    }

}
