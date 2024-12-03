package com.Thymeleaf.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Thymeleaf.ExpenseTracker.exception.RecordNotFoundException;
import com.Thymeleaf.ExpenseTracker.model.Income;

@Service
public interface IIncomeService {
	public List<Income> getIncomeList() throws Exception; // getIncome list
	public List<List<Object>> getIncomeCh(List<Income> listInc); // convert data for Google chart format
	public List<List<Object>> getIncomeLine(List<Income> listInc); // convert data for Google chart format
	public Double totalIncome() throws Exception;
	public void saveIncome(Income income) throws Exception; // post
	public Income fetchInbyId(Long iId) throws RecordNotFoundException; // update
	public void deleteIncome(Long iId) throws RecordNotFoundException; // delete
	
}
