package singleton;

public class Singleton_6 {
    private Singleton_6(){}

    public static Singleton_6 getSingleton(){
        return Inner.INSTANCE;
    }
    static class Inner{
        private static final Singleton_6 INSTANCE = new Singleton_6();
    }
}
