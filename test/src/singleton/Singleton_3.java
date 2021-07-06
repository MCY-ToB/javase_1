package singleton;

public class Singleton_3 {
    public static final Singleton_3 singleton;
    private Singleton_3(){}
    static {
        singleton = new Singleton_3();
    }
}
