package com.Thymeleaf.ExpenseTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eId;
	private String eTitle;
	private String eDesc;
	private String eCategory;
	private LocalDate eDate;
	private Double eAmount;
	public Long geteId() {
		return eId;
	}
	public void seteId(Long eId) {
		this.eId = eId;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteDesc() {
		return eDesc;
	}
	public void seteDesc(String eDesc) {
		this.eDesc = eDesc;
	}
	public String geteCategory() {
		return eCategory;
	}
	public void seteCategory(String eCategory) {
		this.eCategory = eCategory;
	}
	public LocalDate geteDate() {
		return eDate;
	}
	public void seteDate(LocalDate eDate) {
		this.eDate = eDate;
	}
	public Double geteAmount() {
		return eAmount;
	}
	public void seteAmount(Double eAmount) {
		this.eAmount = eAmount;
	}
	public Expense(Long eId, String eTitle, String eDesc, String eCategory, LocalDate eDate, Double eAmount) {
		super();
		this.eId = eId;
		this.eTitle = eTitle;
		this.eDesc = eDesc;
		this.eCategory = eCategory;
		this.eDate = eDate;
		this.eAmount = eAmount;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Expense [eId=" + eId + ", eTitle=" + eTitle + ", eDesc=" + eDesc + ", eCategory=" + eCategory
				+ ", eDate=" + eDate + ", eAmount=" + eAmount + "]";
	}
	
}
