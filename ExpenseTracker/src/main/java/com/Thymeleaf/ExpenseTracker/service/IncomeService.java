package com.Thymeleaf.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Thymeleaf.ExpenseTracker.model.Income;
import com.Thymeleaf.ExpenseTracker.repo.IIncomeRepo;

@Service
public class IncomeService implements IIncomeService {
	
	@Autowired
	private IIncomeRepo iRepo;
	
	@Override
	public List<Income> getIncomeList() {
		//System.out.println(iRepo.findAll());
		return iRepo.findAll();
	}

	@Override
	public List<List<Object>> getIncomeCh(List<Income> listInc) {
		List<List<Object>> listIncomeCh = new ArrayList<>();
		for (Income inc : listInc) {
			listIncomeCh.add(Arrays.asList(inc.getiCategory(), inc.getiAmount()));
		}
		return listIncomeCh;
	}

	@Override
	public void saveIncome(Income income) {
		iRepo.save(income);
	}

	@Override
	public Income fetchInbyId(Long iId) {
		Optional<Income> optional = iRepo.findById(iId);
		//if (optional.isPresent()) {
		return optional.get();
		//}
	}

	@Override
	public void deleteIncome(Long iId) {
		Optional optional = iRepo.findById(iId);
		Income inc = (Income) optional.get();
		iRepo.deleteById(iId);
	}

	@Override
	public List<List<Object>> getIncomeLine(List<Income> listInc) {
		List<List<Object>> listIncomeLine = new ArrayList<>();
		// we are sorting by date
		Collections.sort(listInc, new Comparator<Income>() {
			  public int compare(Income o1, Income o2) {
			      return o1.getiDate().compareTo(o2.getiDate());
			  }
			});
		for (Income inc : listInc) {
			listIncomeLine.add(Arrays.asList(inc.getiDate().toString(), inc.getiAmount()));
			//listIncomeLine.add(Arrays.asList(inc.getiDate().getYear(), inc.getiDate().getMonthValue()));
		}
		return listIncomeLine;
	}

	@Override
	public Double totalIncome() {
		return iRepo.totalIncome();
	}

}
