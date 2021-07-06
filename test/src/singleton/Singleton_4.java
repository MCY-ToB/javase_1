package singleton;

public class Singleton_4 {
    private Singleton_4(){}
    static Singleton_4 INSTANCE;
    public static Singleton_4 getSingleton(){
        if (INSTANCE == null){
            INSTANCE = new Singleton_4();
        }
        return INSTANCE;
    }
}
