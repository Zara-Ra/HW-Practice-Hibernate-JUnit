package ir.maktab.q1.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String accountNumber;
    String creditCardNumber; //todo validate 16 digit
    LocalDate openingDate;
    double credit;
    int cvv2;//todo validate 3 or 4 digit/ create it randomly
    LocalDate expiryDate;
}
