package com.Thymeleaf.ExpenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thymeleaf.ExpenseTracker.model.Income;

public interface IIncomeRepo extends JpaRepository<Income, Long> {

}
