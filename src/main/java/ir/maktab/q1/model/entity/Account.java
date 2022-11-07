package ir.maktab.q1.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@EqualsAndHashCode
@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    int Id;
    String accountNumber;
    String creditCardNumber; //todo validate 16 digit
    LocalDate openingDate;
    double credit;
    int cvv2;
    LocalDate expiryDate;

    public Account(String accountNumber, String creditCardNumber, LocalDate openingDate, double credit, LocalDate expiryDate) {
        this.accountNumber = accountNumber;
        this.creditCardNumber = creditCardNumber;
        this.openingDate = openingDate;
        this.credit = credit;
        this.expiryDate = expiryDate;
        Random random = new Random();
        this.cvv2 = random.nextInt(100, 9999);
    }
}
