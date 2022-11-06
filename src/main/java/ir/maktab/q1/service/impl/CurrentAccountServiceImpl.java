package ir.maktab.q1.service.impl;

import ir.maktab.q1.model.entity.CurrentAccount;
import ir.maktab.q1.service.AbstractService;

public class CurrentAccountServiceImpl extends AbstractService<CurrentAccount> {

    @Override
    public void withdraw(CurrentAccount account,double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > account.getCredit()) {
            throw new RuntimeException("Your balance is not enough");
        }
        account.setCredit(account.getCredit() - amount);
        repository.update(account.getId(),account.getCredit());
    }
}
