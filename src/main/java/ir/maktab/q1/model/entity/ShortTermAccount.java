package ir.maktab.q1.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ShortTermAccount extends Account{
    private double profit;

    public ShortTermAccount(String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, int cvv2, LocalDate expiryDate, double profit) {
        super(accountNumber, creditCardNumber, openingDate, credit, cvv2, expiryDate);
        this.profit = profit;
    }
}

