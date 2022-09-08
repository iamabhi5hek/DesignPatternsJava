package creationalDesignPattern.factory;

public class ComputerFactory {

    private ComputerFactory(){}

    public static Computer getComputer(
            ComputerType computerType,
            String ram,
            String hdd,
            String cpu,
            boolean isGraphicsEnabled,
            boolean isBluetoothEnabled){
        switch (computerType){
            case PersonalComputer:
                return new PersonalComputer(ram, cpu, hdd, isGraphicsEnabled, isBluetoothEnabled);
            case Server:
                return new Server(ram, cpu, hdd, isGraphicsEnabled, isBluetoothEnabled);
            case Laptop:
                return new Laptop(ram, cpu, hdd, isGraphicsEnabled, isBluetoothEnabled);
            default:
                throw new RuntimeException("No valid subclass found");
        }
    }



}
