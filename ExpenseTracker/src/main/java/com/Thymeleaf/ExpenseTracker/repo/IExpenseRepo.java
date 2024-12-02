package com.Thymeleaf.ExpenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Thymeleaf.ExpenseTracker.model.Expense;

@Repository
public interface IExpenseRepo extends JpaRepository<Expense, Long> {
	
	@Query("SELECT SUM(e.eAmount) FROM Expense e")
	public Double totalExpense();

}
