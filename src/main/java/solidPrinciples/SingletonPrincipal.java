package solidPrinciples;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Journal {

    /*
    Class should have single reason to change then its known as SRP
    Class should have single responsibility instead of taking lots and lots of responsibility
     */

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text){
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    public void safe(String fileName) throws FileNotFoundException {
        try(PrintStream printStream = new PrintStream(fileName)){
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

public class SingletonPrincipal {

    public static void main(String[] args) {
        Journal j = new Journal();
        j.addEntry("i woke up");
        j.addEntry("should explore bangalore");
        j.addEntry("get bike");

        System.out.println(j);

    }

}