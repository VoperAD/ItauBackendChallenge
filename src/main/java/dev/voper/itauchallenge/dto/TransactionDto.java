package dev.voper.itauchallenge.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDto(
        @PositiveOrZero @NotNull BigDecimal value,
        @Past @NotNull OffsetDateTime dateTime
) {
}
