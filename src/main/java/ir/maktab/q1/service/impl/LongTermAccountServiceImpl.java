package ir.maktab.q1.service.impl;

import ir.maktab.q1.model.entity.LongTermAccount;

public class LongTermAccountServiceImpl extends ServiceImpl<LongTermAccount> {
    @Override
    public void withdraw(LongTermAccount account, double amount) {
        if (!account.withdrawPossible())
            throw new RuntimeException("Sorry, you can not withdraw from this long term account yet");
        account.setCredit(account.getCredit() - amount);
        repository.update(account.getId(), account.getCredit());
    }
}
