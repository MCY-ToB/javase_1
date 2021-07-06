package test01;
import java.lang.String;
import java.util.Stack;

public class Test_7 {
    Test_7 a = null;
    public static void main(String[] args) {
        Test_7 b = new Test_7();
        Test_7 c = new Test_7();
        b.a = c;
        c.a = b;
        b = null;
        c = null;
    }
}
