package org.ozsoft.portfoliomanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ozsoft.portfoliomanager.domain.Configuration;
import org.ozsoft.portfoliomanager.domain.Transaction;
import org.ozsoft.portfoliomanager.dto.TransactionDTO;
import org.ozsoft.portfoliomanager.dto.StockPriceDTO;
import org.ozsoft.portfoliomanager.service.TransactionService;
import org.ozsoft.portfoliomanager.service.StockPriceService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final Configuration config;

    @Autowired
    private StockPriceService stockPriceService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
        this.config = Configuration.getInstance();
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        List<Transaction> transactions = config.getTransactions();
        
        int start = Math.min(page * size, transactions.size());
        int end = Math.min(start + size, transactions.size());
        
        return transactions.subList(start, end).stream()
                .map(TransactionDTO::fromTransaction)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TransactionDTO getTransaction(@PathVariable int id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found: " + id);
        }
        return TransactionDTO.fromTransaction(transaction);
    }

    @PostMapping
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionService.createTransaction(transactionDTO);
        return TransactionDTO.fromTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/price")
    public StockPriceDTO getStockPrice(@RequestParam String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol is required");
        }
        
        StockPriceDTO result = stockPriceService.getIndianStock(symbol);
        if (result == null) {
            throw new IllegalArgumentException("Stock not found: " + symbol);
        }
        
        return result;
    }
}
