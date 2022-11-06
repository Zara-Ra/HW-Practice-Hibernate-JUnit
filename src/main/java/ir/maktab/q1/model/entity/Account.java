package ir.maktab.q1.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @ToString.Exclude
    int Id;
    String accountNumber;
    String creditCardNumber; //todo validate 16 digit
    LocalDate openingDate;
    double credit;
    int cvv2;//todo validate 3 or 4 digit/ create it randomly
    LocalDate expiryDate;

    public Account(String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, int cvv2, LocalDate expiryDate) {
        this.accountNumber = accountNumber;
        this.creditCardNumber = creditCardNumber;
        this.openingDate = openingDate;
        this.credit = credit;
        this.cvv2 = cvv2;
        this.expiryDate = expiryDate;
    }
}
