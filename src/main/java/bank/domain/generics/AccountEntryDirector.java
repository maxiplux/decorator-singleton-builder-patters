package bank.domain.generics;

import bank.domain.Account;

import java.util.Date;

public interface AccountEntryDirector {


    void contructWithdrawAccountEntry(Builder build, double amount);

    void contructDepositAccountEntry(Builder build, double amount);


    void contructDepositAccountEntryTo(Builder build, String description, double amount, Account toAccount);

    void contructDepositAccountEntryFrom(Builder build, String description, double amount, Account toAccount);
}
