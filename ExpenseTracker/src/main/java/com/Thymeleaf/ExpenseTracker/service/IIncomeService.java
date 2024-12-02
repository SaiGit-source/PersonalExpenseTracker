package com.Thymeleaf.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Thymeleaf.ExpenseTracker.model.Income;

@Service
public interface IIncomeService {
	public List<Income> getIncomeList(); // getIncome list
	public List<List<Object>> getIncomeCh(List<Income> listInc); // convert data for Google chart format
	public List<List<Object>> getIncomeLine(List<Income> listInc); // convert data for Google chart format
	public void saveIncome(Income income); // post
	public Income fetchInbyId(Long iId); // update
	public void deleteIncome(Long iId); // delete
	
}
