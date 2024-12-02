package com.Thymeleaf.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Thymeleaf.ExpenseTracker.model.Expense;
import com.Thymeleaf.ExpenseTracker.repo.IExpenseRepo;

@Service
public class ExpenseService implements IExpenseService {

	@Autowired
	private IExpenseRepo eRepo;

	@Override
	public List<Expense> getExpenseList() {
		return eRepo.findAll();
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
	public void saveExpense(Expense expense) {
		eRepo.save(expense);
	}

	@Override
	public Expense fetchExbyId(Long eId) {
		Optional<Expense> optional = eRepo.findById(eId);
		//if (optional.isPresent()) {
		return optional.get();
		//}
	}

	@Override
	public void deleteExpense(Long eId) {
		Optional<Expense> optional = eRepo.findById(eId);
		Expense exp = optional.get();
		eRepo.deleteById(eId);
	}

	@Override
	public Double totalExpense() {
		return eRepo.totalExpense();
	}
}
