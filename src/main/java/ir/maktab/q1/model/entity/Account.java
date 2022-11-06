package ir.maktab.q1.model.entity;

import java.time.LocalDate;
import java.util.Calendar;

public abstract class Account {
    String accountNumber;
    String creditCardNumber; //todo validate 16 digit
    LocalDate openingDate;
    CreditCard creditCard;
}
