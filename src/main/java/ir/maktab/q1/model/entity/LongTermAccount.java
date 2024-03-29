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
@EqualsAndHashCode(callSuper = true)
@Entity
public class LongTermAccount extends Account {
    private double annualProfit;
    int longTermPeriod;

    public LongTermAccount(String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, LocalDate expiryDate, double annualProfit) {
        super(accountNumber, creditCardNumber, openingDate, credit, expiryDate);
        this.annualProfit = annualProfit;
        this.longTermPeriod = 5;
    }

    public boolean withdrawPossible() {
        LocalDate today = LocalDate.now();
        return today.getYear() - openingDate.getYear() >= longTermPeriod;
    }
}
