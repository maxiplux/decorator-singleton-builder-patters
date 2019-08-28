package bank.domain;

import bank.domain.generics.AccountEntryDirector;
import bank.domain.generics.AccountEntryDirectorImpl;
import bank.domain.generics.Builder;

import java.util.*;


public class Account {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;

	private AccountEntryDirector director = new AccountEntryDirectorImpl();

	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry();
		this.director.contructDepositAccountEntry(entry,amount);
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry();
		this.director.contructWithdrawAccountEntry(entry,amount);
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){

		AccountEntry fromEntry = new AccountEntry();

		this.director.contructDepositAccountEntryFrom(fromEntry,description,amount,toAccount);
		AccountEntry toEntry = new AccountEntry();
		this.director.contructDepositAccountEntryTo(toEntry,description,amount,toAccount);

		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);

	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountnumber=" + accountnumber +
				", entryList=" + entryList +
				", customer=" + customer ;
	}
}
