package basics.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: majunsheng
 * @Date: 2018/4/27
 * List 的一些方法实现
 **/
public class TestList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        replace(list,"c","f");

        System.out.println(list.toString());

        for(String s :list){
            System.out.println(s);
        }
    }



    //replace 方法源码
    public static <E> void replace(List<E> list, E val, E newVal) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
            if (val == null ? it.next() == null : val.equals(it.next()))
                it.set(newVal);
    }
}
