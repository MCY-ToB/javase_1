package test01;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class Test_8 {
    public static void main(String[] args) {
        Person p1 = new Person(23,"zhangsan");
        Person p2 = new Person(33,"lisi");
        Person p3 = new Person(13,"wangwu");
        Person p4 = new Person(21,"zhaoliu");
        Person p5 = new Person(21,"zisi");
        Person p6 = new Person(21,"lisi");
        TreeSet<Person> ts = new TreeSet(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });
        ts.add(p1);
        ts.add(p2);
        ts.add(p3);
        ts.add(p4);
        ts.add(p5);
        ts.add(p6);


        for (Person p :
                ts) {
            System.out.println(p);
        }
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
