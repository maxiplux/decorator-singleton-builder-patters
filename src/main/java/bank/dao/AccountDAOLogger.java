package bank.dao;

import bank.domain.Account;

import java.util.Collection;

public class AccountDAOLogger  extends AccountDaoDecorator  implements  SimpleLogger {


    public  AccountDAOLogger(IAccountDAO iAccountDAO)
    {
       super(iAccountDAO);

    }
    @Override
    public void saveAccount(Account account) {
        this.log("saveAccount"+account);
        super.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        this.log("updateAccount"+account);
        super.updateAccount(account);

    }

    @Override
    public Account loadAccount(long accountnumber) {
        this.log("loadAccount"+accountnumber);
        return super.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        this.log("getAccounts");
        return  super.getAccounts();
    }

    @Override
    public void log(String action) {
        System.out.println("I am a Decorator making logs for action "+action);
    }
}
