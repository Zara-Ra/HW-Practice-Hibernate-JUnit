package ir.maktab.q1.service.impl;

import ir.maktab.q1.model.entity.LongTermAccount;
import ir.maktab.q1.service.AbstractService;

import java.time.LocalDate;

public class LongTermAccountServiceImpl extends AbstractService<LongTermAccount> {
    @Override
    public void withdraw(LongTermAccount account, double amount) {
        if(!account.withdrawPossible())
            throw new RuntimeException("Sorry, you can not withdraw from this long term account yet");
        account.setCredit(account.getCredit() - amount);
        repository.update(account.getId(),account.getCredit());
    }
}
