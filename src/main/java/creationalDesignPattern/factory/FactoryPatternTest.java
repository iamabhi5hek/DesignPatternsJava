package creationalDesignPattern.factory;

public class FactoryPatternTest {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(ComputerType.PersonalComputer, "16 GB", "120GB"
        ,"2,23GHz", true, true);

        System.out.println("PC Config: " + pc);

    }

}
