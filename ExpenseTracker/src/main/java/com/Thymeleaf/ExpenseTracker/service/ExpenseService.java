package com.Thymeleaf.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Thymeleaf.ExpenseTracker.exception.RecordNotFoundException;
import com.Thymeleaf.ExpenseTracker.model.Expense;
import com.Thymeleaf.ExpenseTracker.repo.IExpenseRepo;

@Service
public class ExpenseService implements IExpenseService {

	@Autowired
	private IExpenseRepo eRepo;

	@Override
	public List<Expense> getExpenseList() throws Exception {
		try {
			List<Expense> lstE = eRepo.findAll();
			return lstE;
		}
		catch(Exception e) {
			throw new Exception("Unable to find records");
		}
		
	}

	@Override
	public List<List<Object>> getExpensePie(List<Expense> listExp) {
		List<List<Object>> listExpensePie = new ArrayList<>();
		for (Expense exp : listExp) {
			listExpensePie.add(Arrays.asList(exp.geteCategory(), exp.geteAmount()));
		}
		return listExpensePie;
	}

	@Override
	public List<List<Object>> getExpenseLine(List<Expense> listExp) {
		List<List<Object>> listExpenseLine = new ArrayList<>();
		// we are sorting by date
		Collections.sort(listExp, new Comparator<Expense>() {
			  public int compare(Expense o1, Expense o2) {
			      return o1.geteDate().compareTo(o2.geteDate());
			  }
			});
		for (Expense exp : listExp) {
			listExpenseLine.add(Arrays.asList(exp.geteDate().toString(), exp.geteAmount()));
			//listIncomeLine.add(Arrays.asList(inc.getiDate().getYear(), inc.getiDate().getMonthValue()));
		}
		return listExpenseLine;
	}

	@Override
	public void saveExpense(Expense expense) throws Exception {
		try {
			eRepo.save(expense);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Expense fetchExbyId(Long eId) throws RecordNotFoundException {
		Optional<Expense> optional = eRepo.findById(eId);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new RecordNotFoundException("Record not found");
		}
	}

	@Override
	public void deleteExpense(Long eId) throws RecordNotFoundException {
		Optional<Expense> optional = eRepo.findById(eId);
		if (optional.isPresent()) {
			eRepo.deleteById(eId);
		}
		else {
			throw new RecordNotFoundException("Record not found for deletion");
		}
		
	}

	@Override
	public Double totalExpense() {
		return eRepo.totalExpense();
	}
}
