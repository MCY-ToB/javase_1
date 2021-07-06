package test07;

import java.util.Comparator;

public class LambdaTest {
    public static void main(String[] args) {
        Comparator<Integer> c1 = LambdaTest::compare;
        Comparator<Integer> c2 = LambdaTest :: compare2;
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    public static int compare2(int x,int y) {
        return x;
    }
}
