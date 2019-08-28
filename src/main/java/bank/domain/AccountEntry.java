package bank.domain;

import bank.domain.generics.Builder;

import java.util.Date;

public class AccountEntry  implements Builder {
	private Date date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	
	public AccountEntry() {
	}

	public AccountEntry(Date date, double amount, String description, String fromAccountNumber, String fromPersonName) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	public double getAmount() {
		return amount;
	}



	public Date getDate() {
		return date;
	}



	public String getDescription() {
		return description;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}


	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public String getFromPersonName() {
		return fromPersonName;
	}


	
}
