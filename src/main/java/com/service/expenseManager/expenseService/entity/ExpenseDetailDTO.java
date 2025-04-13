package com.service.expenseManager.expenseService.entity;

import jakarta.persistence.Id;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpenseDetailDTO {

    private String amount;
    private String transactionType;
    private String accountNumber;
    @Id()
    private String transactionId;
    private String date;
    private String merchant;

    public ExpenseDetails transformToExpenseDetails() {
        return ExpenseDetails.builder()
                .amount(amount)
                .transactionType(transactionType)
                .accountNumber(accountNumber)
                .transactionId(transactionId)
                .date(date)
                .merchant(merchant).build();
    }
}
