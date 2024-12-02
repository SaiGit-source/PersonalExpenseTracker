package com.Thymeleaf.ExpenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Thymeleaf.ExpenseTracker.model.Income;

@Repository
public interface IIncomeRepo extends JpaRepository<Income, Long> {

	@Query("SELECT SUM(i.iAmount) FROM Income i")
	public Double totalIncome();

}
