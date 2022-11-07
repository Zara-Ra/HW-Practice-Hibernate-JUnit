package ir.maktab.q5;

public class StringToInt {
    private final static int LIMIT = 32767;

    public static int convert(String string) {
        if (!Validate.isStringValid(string))
            throw new InvalidStringException("Invalid Input String");
        int result = Integer.parseInt(string);
        if (result > LIMIT || result < -LIMIT)
            throw new InvalidStringException("Input Number Not In Range");
        return result;
    }
}
