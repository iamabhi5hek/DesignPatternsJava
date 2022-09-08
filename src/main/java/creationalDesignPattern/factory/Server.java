package creationalDesignPattern.factory;

public class Server implements Computer{

    private String ram;
    private String cpu;
    private String hdd;
    private boolean isGraphicsEnabled;
    private boolean isBluetoothEnabled;

    public Server(String ram, String cpu, String hdd, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
        this.isGraphicsEnabled = isGraphicsEnabled;
        this.isBluetoothEnabled = isBluetoothEnabled;
    }

    @Override
    public String ram() {
        return this.ram;
    }

    @Override
    public String hdd() {
        return this.hdd;
    }

    @Override
    public String cpu() {
        return this.cpu;
    }

    @Override
    public boolean isGraphicsEnabled() {
        return this.isGraphicsEnabled;
    }

    @Override
    public boolean isBluetoothEnabled() {
        return this.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", hdd='" + hdd + '\'' +
                ", isGraphicsEnabled=" + isGraphicsEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }
}
