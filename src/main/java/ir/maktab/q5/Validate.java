package ir.maktab.q5;

public class Validate {
    public static boolean isStringValid(String s) {// -32767
        return !s.equals("") && s.matches("-?[0-9]{1,5}");
    }
}
