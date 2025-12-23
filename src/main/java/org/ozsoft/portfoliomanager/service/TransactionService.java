package org.ozsoft.portfoliomanager.service;

import org.springframework.stereotype.Service;
import org.ozsoft.portfoliomanager.domain.Configuration;
import org.ozsoft.portfoliomanager.domain.Transaction;
import org.ozsoft.portfoliomanager.domain.TransactionType;
import org.ozsoft.portfoliomanager.dto.TransactionDTO;

@Service
public class TransactionService {

    private final Configuration config;

    public TransactionService() {
        this.config = Configuration.getInstance();
    }

    public Transaction getTransactionById(int id) {
        for (Transaction transaction : config.getTransactions()) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setDate(transactionDTO.getDate());
        transaction.setSymbol(transactionDTO.getSymbol());
        transaction.setType(TransactionType.valueOf(transactionDTO.getType()));
        transaction.setNoOfShares(transactionDTO.getNoOfShares());
        transaction.setPrice(transactionDTO.getPrice());
        transaction.setCost(transactionDTO.getCost());

        config.addTransaction(transaction);
        config.save();

        return transaction;
    }

    public void deleteTransaction(int id) {
        Transaction transaction = getTransactionById(id);
        if (transaction != null) {
            config.deleteTransaction(transaction);
            config.save();
        }
    }
}
