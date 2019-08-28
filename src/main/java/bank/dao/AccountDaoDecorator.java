package bank.dao;

import bank.domain.Account;

import java.util.Collection;

public class AccountDaoDecorator  implements IAccountDAO {
    private IAccountDAO wrapper;

    public  AccountDaoDecorator(IAccountDAO wrapper)
    {
        this.wrapper=wrapper;
    }


    @Override
    public void saveAccount(Account account) {
        this.wrapper.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {

        this.wrapper.updateAccount(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        return this.wrapper.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return this.wrapper.getAccounts();
    }
}
