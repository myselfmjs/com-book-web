package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合遍历
 */
public class Iterator {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");


        java.util.Iterator<String> ite = list.iterator();

        while (ite.hasNext()){
            System.out.println(ite.next());
        }


    }

}
