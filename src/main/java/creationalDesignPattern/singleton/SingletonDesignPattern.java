package creationalDesignPattern.singleton;

/*
    <li>Type of creational design pattern.</li>
    <li>Creates only 1 instance of class.</li>
    <li>Provide only one global access point to object.</li>
    <li>Calendar class in java.</li>
 */
public class SingletonDesignPattern {

    //will get instantiated whenever class loads.
    private static SingletonDesignPattern earlyInstance = new SingletonDesignPattern();

    //when multiple threads are there.
    private static SingletonDesignPattern lazyInstance = null;

    private SingletonDesignPattern(){}

    public static SingletonDesignPattern getEarlyInstance(){
        return earlyInstance;
    }

    public static SingletonDesignPattern getLazyInstance(){
        if(lazyInstance == null){
            synchronized (SingletonDesignPattern.class){
                if(lazyInstance == null){
                    lazyInstance = new SingletonDesignPattern();
                }
            }
        }
        return lazyInstance;
    }

}
