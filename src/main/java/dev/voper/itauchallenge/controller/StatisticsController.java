package dev.voper.itauchallenge.controller;

import dev.voper.itauchallenge.dto.SummaryDto;
import dev.voper.itauchallenge.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private static final Duration SIXTY_SECONDS = Duration.ofSeconds(60);

    private final StatisticsService statisticsService;

    @GetMapping
    public SummaryDto getStatistics() {
        return statisticsService.getStatistics(SIXTY_SECONDS);
    }

}
