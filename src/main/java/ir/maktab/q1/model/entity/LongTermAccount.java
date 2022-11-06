package ir.maktab.q1.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@Entity
public class LongTermAccount extends Account{
    private double annualProfit;

    public LongTermAccount(String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, int cvv2, LocalDate expiryDate, double annualProfit) {
        super(accountNumber, creditCardNumber, openingDate, credit, cvv2, expiryDate);
        this.annualProfit = annualProfit;
    }
}
