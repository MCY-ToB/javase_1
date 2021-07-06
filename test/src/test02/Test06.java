package test02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test06 {
    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            //System.out.println(iterator.next());
            if ("2".equals(iterator.next())){
                iterator.remove();
            }
        }

        /*List<String> all = new ArrayList<String>();
        all.add("a");
        all.add("b");
        all.add("c");

        Iterator<String> iterator = all.iterator();//实例化迭代器

        while(iterator.hasNext()){
            String str=iterator.next();//读取当前集合数据元素
            if("b".equals(str)){
                //all.remove(str);//使用集合当中的remove方法对当前迭代器当中的数据元素值进行删除操作(注:此操作将会破坏整个迭代器结构)使得迭代器在接下来将不会起作用
                iterator.remove();
            }else{
                System.out.println( str+" ");
            }
        }
        System.out.println("\n删除\"b\"之后的集合当中的数据为:"+all);*/
    }
}
