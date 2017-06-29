package array;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by majunsheng on 2017/6/29.
 */
public class testArray {
    public static void main(String[] args) {
        List<String> array1 = new ArrayList<String>();
        array1.add("a");
        array1.add("b");
        array1.add("c");
        array1.add("d");
        List<String> array2 = new ArrayList<String>();
        array2.addAll(array1);
        array2.addAll(2,array1);
        System.out.println(array1.toString());
        System.out.println(array2.toString());

        Collections.reverse(array1);
        System.out.println(array1);

        //Array 转 String
        String join = StringUtils.join(array1, "-");
        System.out.println(join);
    }
}
