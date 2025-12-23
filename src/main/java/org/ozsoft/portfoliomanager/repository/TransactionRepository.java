package org.ozsoft.portfoliomanager.repository;

import org.ozsoft.portfoliomanager.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    List<TransactionEntity> findBySymbol(String symbol);
    List<TransactionEntity> findAllByOrderByDateAsc();
}
