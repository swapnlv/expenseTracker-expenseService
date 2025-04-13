package com.service.expenseManager.expenseService.repository;

import com.service.expenseManager.expenseService.entity.ExpenseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseDetails,String> {


}
