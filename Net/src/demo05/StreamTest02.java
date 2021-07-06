package demo05;

import java.util.stream.Stream;

public class StreamTest02 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("1", "2", "3");
//        Stream<Integer> stream2 = stream1.map(s ->  Integer.parseInt(s));
        stream1.forEach(i -> System.out.println(i + 10));
    }
}
