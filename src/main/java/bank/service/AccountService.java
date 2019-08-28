package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private EmailSender emailSender;

	
	public AccountService(){
		accountDAO=new AccountDAOLogger( new AccountDAO());
		this.emailSender = EmailSender.getInstance();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		this.emailSender.sendEmail(customer.getName());
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		this.emailSender.sendEmail(account.getCustomer().getName());
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		this.emailSender.sendEmail(fromAccount.getCustomer().getName());
		this.emailSender.sendEmail(toAccount.getCustomer().getName());
		accountDAO.updateAccount(toAccount);
	}
}
