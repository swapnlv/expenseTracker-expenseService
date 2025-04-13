package com.service.expenseManager.expenseService.service;

import com.service.expenseManager.expenseService.entity.ExpenseDetailDTO;
import com.service.expenseManager.expenseService.entity.ExpenseDetails;
import com.service.expenseManager.expenseService.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseDetailDTO saveOrUpdateExpenseDetails(ExpenseDetailDTO expenseDetailDTO) {
        // Check if the transaction already exists
        Optional<ExpenseDetails> existingExpense = expenseRepository.findById(expenseDetailDTO.getTransactionId());

        ExpenseDetails savedExpense = existingExpense
                .map(expense -> { // If expense exists, update it
                    ExpenseDetails updatedExpense = expenseDetailDTO.transformToExpenseDetails();
                    updatedExpense.setTransactionId(expense.getTransactionId()); // Retain ID
                    return expenseRepository.save(updatedExpense);
                })
                .orElseGet(() -> expenseRepository.save(expenseDetailDTO.transformToExpenseDetails())); // Otherwise, create new

        return new ExpenseDetailDTO(
                savedExpense.getAmount(),
                savedExpense.getTransactionType(),
                savedExpense.getAccountNumber(),
                savedExpense.getTransactionId(),
                savedExpense.getDate(),
                savedExpense.getMerchant()
        );
    }

}
