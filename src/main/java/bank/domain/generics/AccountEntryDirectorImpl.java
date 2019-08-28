package bank.domain.generics;

import bank.domain.Account;
import bank.domain.AccountEntry;

import java.util.Date;

public class AccountEntryDirectorImpl implements  AccountEntryDirector {
    @Override
    public void contructWithdrawAccountEntry(Builder build, double amount) {
        build.setDate(new Date());
        build.setFromAccountNumber("");
        build.setDescription("withdraw");
        build.setFromPersonName("");
        build.setAmount(-amount);
    }

    @Override
    public void contructDepositAccountEntry(Builder build, double amount) {
        build.setDate(new Date());

        build.setFromAccountNumber("");
        build.setDescription("deposit");

        build.setFromPersonName("");
        build.setAmount(amount);
    }


    @Override
    public void contructDepositAccountEntryTo(Builder build, String description, double amount, Account toAccount) {
        build.setDate(new Date());
        build.setDescription(description);

        build.setAmount(amount);

        build.setFromAccountNumber(""+toAccount.getAccountnumber());
        build.setFromPersonName(toAccount.getCustomer().getName());
    }

    @Override
    public void contructDepositAccountEntryFrom(Builder build, String description, double amount, Account toAccount) {
        build.setDate(new Date());

        build.setDescription(description);
        build.setAmount(-amount);

        build.setFromAccountNumber(""+toAccount.getAccountnumber());
        build.setFromPersonName(toAccount.getCustomer().getName());
    }
}
