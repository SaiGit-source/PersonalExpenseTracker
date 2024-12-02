package com.Thymeleaf.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Thymeleaf.ExpenseTracker.model.Expense;

@Service
public interface IExpenseService {
	
	public List<Expense> getExpenseList(); // getExpense list
	public List<List<Object>> getIncomeCh(List<Expense> listExp); // convert data for Google chart format
	public void saveExpense(Expense expense); // post
	public Expense fetchExbyId(Integer eId); // update
	public void deleteExpense(Integer eId); // delete

}
