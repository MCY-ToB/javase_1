package oom;

public class StackOverFlowError {
    public static void main(String[] args) {
        f();
    }

    private static void f() {
        f();
    }
}
