package org.ozsoft.portfoliomanager.dto;

import java.math.BigDecimal;

import org.ozsoft.portfoliomanager.domain.Portfolio;

public class PortfolioDTO {

    private BigDecimal currentCost;
    private BigDecimal currentValue;
    private BigDecimal currentResult;
    private BigDecimal currentResultPercentage;
    private BigDecimal totalCost;
    private BigDecimal annualIncome;
    private BigDecimal totalIncome;
    private BigDecimal yieldOnCost;
    private BigDecimal realizedResult;
    private BigDecimal totalReturn;
    private BigDecimal totalReturnPercentage;

    public PortfolioDTO() {
    }

    public PortfolioDTO(Portfolio portfolio) {
        this.currentCost = portfolio.getCurrentCost();
        this.currentValue = portfolio.getCurrentValue();
        this.currentResult = portfolio.getCurrentResult();
        this.currentResultPercentage = portfolio.getCurrentResultPercentage();
        this.totalCost = portfolio.getTotalCost();
        this.annualIncome = portfolio.getAnnualIncome();
        this.totalIncome = portfolio.getTotalIncome();
        this.yieldOnCost = portfolio.getYieldOnCost();
        this.realizedResult = portfolio.getRealizedResult();
        this.totalReturn = portfolio.getTotalReturn();
        this.totalReturnPercentage = portfolio.getTotalReturnPercentage();
    }

    public static PortfolioDTO fromPortfolio(Portfolio portfolio) {
        return new PortfolioDTO(portfolio);
    }

    public BigDecimal getCurrentCost() { return currentCost; }
    public void setCurrentCost(BigDecimal currentCost) { this.currentCost = currentCost; }

    public BigDecimal getCurrentValue() { return currentValue; }
    public void setCurrentValue(BigDecimal currentValue) { this.currentValue = currentValue; }

    public BigDecimal getCurrentResult() { return currentResult; }
    public void setCurrentResult(BigDecimal currentResult) { this.currentResult = currentResult; }

    public BigDecimal getCurrentResultPercentage() { return currentResultPercentage; }
    public void setCurrentResultPercentage(BigDecimal currentResultPercentage) { this.currentResultPercentage = currentResultPercentage; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public BigDecimal getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(BigDecimal annualIncome) { this.annualIncome = annualIncome; }

    public BigDecimal getTotalIncome() { return totalIncome; }
    public void setTotalIncome(BigDecimal totalIncome) { this.totalIncome = totalIncome; }

    public BigDecimal getYieldOnCost() { return yieldOnCost; }
    public void setYieldOnCost(BigDecimal yieldOnCost) { this.yieldOnCost = yieldOnCost; }

    public BigDecimal getRealizedResult() { return realizedResult; }
    public void setRealizedResult(BigDecimal realizedResult) { this.realizedResult = realizedResult; }

    public BigDecimal getTotalReturn() { return totalReturn; }
    public void setTotalReturn(BigDecimal totalReturn) { this.totalReturn = totalReturn; }

    public BigDecimal getTotalReturnPercentage() { return totalReturnPercentage; }
    public void setTotalReturnPercentage(BigDecimal totalReturnPercentage) { this.totalReturnPercentage = totalReturnPercentage; }
}
