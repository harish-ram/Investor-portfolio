package org.ozsoft.portfoliomanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ozsoft.portfoliomanager.domain.Configuration;
import org.ozsoft.portfoliomanager.domain.Portfolio;
import org.ozsoft.portfoliomanager.domain.Position;
import org.ozsoft.portfoliomanager.dto.PortfolioDTO;
import org.ozsoft.portfoliomanager.dto.PositionDTO;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private final Configuration config;

    public PortfolioController() {
        this.config = Configuration.getInstance();
    }

    @GetMapping
    public PortfolioDTO getPortfolio() {
        Portfolio portfolio = config.getPortfolio();
        return PortfolioDTO.fromPortfolio(portfolio);
    }

    @GetMapping("/positions")
    public List<PositionDTO> getPositions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Portfolio portfolio = config.getPortfolio();
        List<Position> positions = new java.util.ArrayList<>(portfolio.getPositions());
        
        int start = Math.min(page * size, positions.size());
        int end = Math.min(start + size, positions.size());
        
        return positions.subList(start, end).stream()
                .map(PositionDTO::fromPosition)
                .collect(Collectors.toList());
    }

    @GetMapping("/positions/{symbol}")
    public PositionDTO getPosition(@PathVariable String symbol) {
        Portfolio portfolio = config.getPortfolio();
        for (Position position : portfolio.getPositions()) {
            if (position.getStock().getSymbol().equals(symbol)) {
                return PositionDTO.fromPosition(position);
            }
        }
        throw new IllegalArgumentException("Position not found for symbol: " + symbol);
    }
}
