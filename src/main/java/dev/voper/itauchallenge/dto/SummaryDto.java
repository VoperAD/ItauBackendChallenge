package dev.voper.itauchallenge.dto;

import java.math.BigDecimal;

public record SummaryDto(
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max
) {
}
