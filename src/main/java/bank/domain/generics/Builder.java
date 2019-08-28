package bank.domain.generics;

import java.util.Date;

public interface Builder {

    public void setAmount(double amount);
    public void setDate(Date date);
    public void setDescription(String description);
    public void setFromAccountNumber(String fromAccountNumber);
    public void setFromPersonName(String fromPersonName);

}
