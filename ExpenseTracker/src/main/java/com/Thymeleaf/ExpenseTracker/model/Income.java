package com.Thymeleaf.ExpenseTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Income {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long iId;
	private String iTitle;
	private String iDesc;
	private String iCategory;
	private LocalDate iDate;
	private Double iAmount;
	public Long getiId() {
		return iId;
	}
	public void setiId(Long iId) {
		this.iId = iId;
	}
	public String getiTitle() {
		return iTitle;
	}
	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}
	public String getiDesc() {
		return iDesc;
	}
	public void setiDesc(String iDesc) {
		this.iDesc = iDesc;
	}
	public String getiCategory() {
		return iCategory;
	}
	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}
	public LocalDate getiDate() {
		return iDate;
	}
	public void setiDate(LocalDate iDate) {
		this.iDate = iDate;
	}
	public Double getiAmount() {
		return iAmount;
	}
	public void setiAmount(Double iAmount) {
		this.iAmount = iAmount;
	}
	public Income(Long iId, String iTitle, String iDesc, String iCategory, LocalDate iDate, Double iAmount) {
		super();
		this.iId = iId;
		this.iTitle = iTitle;
		this.iDesc = iDesc;
		this.iCategory = iCategory;
		this.iDate = iDate;
		this.iAmount = iAmount;
	}
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Income [iId=" + iId + ", iTitle=" + iTitle + ", iDesc=" + iDesc + ", iCategory=" + iCategory
				+ ", iDate=" + iDate + ", iAmount=" + iAmount + "]";
	}
	
}
