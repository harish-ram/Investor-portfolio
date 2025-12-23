package org.ozsoft.portfoliomanager.dto;

import java.math.BigDecimal;

import org.ozsoft.portfoliomanager.domain.Position;

public class PositionDTO {

    private String symbol;
    private String stockName;
    private BigDecimal noOfShares;
    private BigDecimal currentCost;
    private BigDecimal totalCost;
    private BigDecimal costPerShare;
    private BigDecimal currentValue;
    private BigDecimal unrealizedResult;
    private BigDecimal unrealizedResultPercentage;
    private BigDecimal totalIncome;
    private BigDecimal annualIncome;
    private BigDecimal yieldOnCost;
    private BigDecimal totalReturn;

    public PositionDTO() {
    }

    public PositionDTO(Position position) {
        this.symbol = position.getStock().getSymbol();
        this.stockName = position.getStock().getName();
        this.noOfShares = position.getNoOfShares();
        this.currentCost = position.getCurrentCost();
        this.totalCost = position.getTotalCost();
        this.costPerShare = position.getCostPerShare();
        this.currentValue = position.getCurrentValue();
        this.unrealizedResult = position.getCurrentResult();
        this.unrealizedResultPercentage = position.getCurrentResultPercentage();
        this.totalIncome = position.getTotalIncome();
        this.annualIncome = position.getAnnualIncome();
        this.yieldOnCost = position.getYieldOnCost();
        this.totalReturn = position.getTotalReturn();
    }

    public static PositionDTO fromPosition(Position position) {
        return new PositionDTO(position);
    }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getStockName() { return stockName; }
    public void setStockName(String stockName) { this.stockName = stockName; }

    public BigDecimal getNoOfShares() { return noOfShares; }
    public void setNoOfShares(BigDecimal noOfShares) { this.noOfShares = noOfShares; }

    public BigDecimal getCurrentCost() { return currentCost; }
    public void setCurrentCost(BigDecimal currentCost) { this.currentCost = currentCost; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public BigDecimal getCostPerShare() { return costPerShare; }
    public void setCostPerShare(BigDecimal costPerShare) { this.costPerShare = costPerShare; }

    public BigDecimal getCurrentValue() { return currentValue; }
    public void setCurrentValue(BigDecimal currentValue) { this.currentValue = currentValue; }

    public BigDecimal getUnrealizedResult() { return unrealizedResult; }
    public void setUnrealizedResult(BigDecimal unrealizedResult) { this.unrealizedResult = unrealizedResult; }

    public BigDecimal getUnrealizedResultPercentage() { return unrealizedResultPercentage; }
    public void setUnrealizedResultPercentage(BigDecimal unrealizedResultPercentage) { this.unrealizedResultPercentage = unrealizedResultPercentage; }

    public BigDecimal getTotalIncome() { return totalIncome; }
    public void setTotalIncome(BigDecimal totalIncome) { this.totalIncome = totalIncome; }

    public BigDecimal getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(BigDecimal annualIncome) { this.annualIncome = annualIncome; }

    public BigDecimal getYieldOnCost() { return yieldOnCost; }
    public void setYieldOnCost(BigDecimal yieldOnCost) { this.yieldOnCost = yieldOnCost; }

    public BigDecimal getTotalReturn() { return totalReturn; }
    public void setTotalReturn(BigDecimal totalReturn) { this.totalReturn = totalReturn; }
}
