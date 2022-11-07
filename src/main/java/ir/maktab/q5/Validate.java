package ir.maktab.q5;

public class Validate {
    public static boolean isStringValid(String s){// -32767
        if (!s.equals("") && s.matches("-?[0-9]{1,5}"))
            return true;
        return false;
    }
}
