package creationalDesignPattern.singleton;

public class SingletonEnumTest {

    public static void main(String[] args) {

        SingletonEnum enum1 = SingletonEnum.GETINSTANCE;
        SingletonEnum enum2 = SingletonEnum.GETINSTANCE;

        System.out.println(enum1.hashCode());
        System.out.println(enum2.hashCode());
    }

}
