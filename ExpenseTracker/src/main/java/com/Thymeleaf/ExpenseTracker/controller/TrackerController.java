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
