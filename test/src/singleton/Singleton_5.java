package singleton;

public class Singleton_5 {
    private Singleton_5(){}
    private static volatile Singleton_5 INSTANCE;
    public static Singleton_5 getSingleton(){
        if (INSTANCE == null){
            synchronized (Singleton_5.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_5();
                }
            }
            return INSTANCE;
        }
        return INSTANCE;
    }
}
