package test;

public interface C {
    public abstract void m1();
    default int getNum(int num){
        return num;
    }
}
