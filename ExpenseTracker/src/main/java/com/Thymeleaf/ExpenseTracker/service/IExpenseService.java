package com.Thymeleaf.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Thymeleaf.ExpenseTracker.model.Expense;
import com.Thymeleaf.ExpenseTracker.model.Income;

@Service
public interface IExpenseService {
	
	public List<Expense> getExpenseList(); // getExpense list
	public List<List<Object>> getExpensePie(List<Expense> listExp); // convert data for Google chart format
	public List<List<Object>> getExpenseLine(List<Expense> listExp); // convert data for Google chart format
	public Double totalExpense();
	public void saveExpense(Expense expense); // post
	public Expense fetchExbyId(Long eId); // update
	public void deleteExpense(Long eId); // delete

}
