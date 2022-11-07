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
public class CurrentAccount extends Account{
    private String checkbook;

    public CurrentAccount( String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, LocalDate expiryDate, String checkbook) {
        super(accountNumber, creditCardNumber, openingDate, credit, expiryDate);
        this.checkbook = checkbook;
    }

}
