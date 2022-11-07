package ir.maktab.q1.util.validation;

import ir.maktab.q1.util.exceptions.ValidationException;

public class AccountValidation {
    public static void validCardNumber(String cardNumber) throws ValidationException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new ValidationException("Credit Card number should be 16 digits");
    }
}
