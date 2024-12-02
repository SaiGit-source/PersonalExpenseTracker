package com.Thymeleaf.ExpenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thymeleaf.ExpenseTracker.model.Expense;

public interface IExpenseRepo extends JpaRepository<Expense, Long> {

}
