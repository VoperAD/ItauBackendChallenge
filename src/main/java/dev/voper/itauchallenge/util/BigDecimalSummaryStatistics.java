package dev.voper.itauchallenge.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.function.Consumer;

@Getter
@NoArgsConstructor
public class BigDecimalSummaryStatistics implements Consumer<BigDecimal> {

    private long count = 0;
    private BigDecimal sum = BigDecimal.ZERO;
    private BigDecimal avg = BigDecimal.ZERO;
    private BigDecimal min = BigDecimal.ZERO;
    private BigDecimal max = BigDecimal.ZERO;

    @Override
    public void accept(BigDecimal other) {
        ++count;

        if (count == 1) {
            min = other;
        }

        min = min.min(other);
        max = max.max(other);
        sum = sum.add(other);
        avg = sum.divide(BigDecimal.valueOf(count));
    }

}
