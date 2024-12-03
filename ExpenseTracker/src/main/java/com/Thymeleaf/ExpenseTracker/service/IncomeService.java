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
import com.Thymeleaf.ExpenseTracker.model.Income;
import com.Thymeleaf.ExpenseTracker.repo.IIncomeRepo;

@Service
public class IncomeService implements IIncomeService {
	
	@Autowired
	private IIncomeRepo iRepo;
	
	@Override
	public List<Income> getIncomeList() throws Exception {
		//System.out.println(iRepo.findAll());
		try{
			List<Income> lstI = iRepo.findAll();
			return lstI;
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
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
	public void saveIncome(Income income) throws Exception {
		try {
			iRepo.save(income);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Income fetchInbyId(Long iId) throws RecordNotFoundException {
		Optional<Income> optional = iRepo.findById(iId);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new RecordNotFoundException("Record not found during fetching");
		}
	}

	@Override
	public void deleteIncome(Long iId) throws RecordNotFoundException {
		Optional optional = iRepo.findById(iId);
		if (optional.isPresent()) {
			iRepo.deleteById(iId);
		}
		else {
			throw new RecordNotFoundException("Record not found for deletion");
		}
		
		
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
	public Double totalIncome() throws Exception {
		try {
			return iRepo.totalIncome();
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
