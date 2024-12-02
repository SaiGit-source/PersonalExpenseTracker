package com.Thymeleaf.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Thymeleaf.ExpenseTracker.model.Income;
import com.Thymeleaf.ExpenseTracker.service.IExpenseService;
import com.Thymeleaf.ExpenseTracker.service.IIncomeService;

//http://localhost:8788/Tracker/Homepage

@Controller
@RequestMapping("/")
public class TrackerController {
	
	@Autowired
	private IIncomeService iservice;
	//@Autowired
	private IExpenseService eservice;
	
	@GetMapping("/Homepage")
	public String TrackerCharts(Model model) {
		List<Income> listIncome = iservice.getIncomeList();
		List<List<Object>> listIncomeCh = iservice.getIncomeCh(listIncome);
		model.addAttribute("IncomePieKey", listIncomeCh);
		List<List<Object>> listIncomeLine = iservice.getIncomeLine(listIncome);
		//System.out.println(listIncomeLine);
		model.addAttribute("IncomeLineKey", listIncomeLine);
		return "Tracker";
	}
	
	// to display customer list 
	@GetMapping("/TransactionsLst")
	public String getAllIncData(Model model) {
		List<Income> incomes = iservice.getIncomeList();
		incomes.forEach(i->System.out.println(i));
		model.addAttribute("IncomeKey", incomes);
		return "Transactions";
	}
	
	@GetMapping("/updateIncome")
	public String updateIx(@RequestParam("incIDKey")Long incID, Model model) {
		//cxidKey is coming from cxlistHomePage
		Income incRecord = iservice.fetchInbyId(incID);
		// fetch Income record and populate update form
		// send incRecord to updateForm
		model.addAttribute("incRecordKey", incRecord);
		// now the record is available for two-way binding at updateForm
		return "updateIncForm";
	}
	
	
	@GetMapping("/deleteIncome")
	public String deleteIx(@RequestParam("incIDKey")Long incID) {
		iservice.deleteIncome(incID);
		return "redirect:/TransactionsLst";
	}
	
	@GetMapping("/EnterIncome")
	public String EnterIncomeForm(@ModelAttribute("IncKey")Income income, Model model) {
		model.addAttribute("IncKey", new Income());
		return "IncomeForm";
	}
	
	@PostMapping("/saveIncome")
	public String saveIncome(@ModelAttribute("IncKey")Income income) {
		iservice.saveIncome(income);
		return "redirect:/Homepage";
		//return "IncomeForm";
	}

}
