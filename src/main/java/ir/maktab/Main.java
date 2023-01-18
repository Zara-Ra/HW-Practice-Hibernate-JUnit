package ir.maktab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        Stream<String> stream = list.stream();
        list.add("d");
        stream.forEach(System.out::print);
    }
}
