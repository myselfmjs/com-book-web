package array;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
        array2.addAll(2,array1);// 将指定集合的所有元素插入到该列表中，从指定位置开始
                                       //  array1 插入到 array2 的List 中 从下标为 1 的位置开始
        System.out.println("1:  " + array1.toString());
        System.out.println("2:  " + array2.toString());

        Collections.reverse(array1);
        System.out.println("3:  " + array1);

        //Array 转 String
        String join = StringUtils.join(array1, "-");
        System.out.println("4:  " + join);

        /**
         * 数组转LIST 用asList时 无法进行add remove 等操纵
         * 原因：Arrays.asList方法返回的ArrayList是继承自AbstractList同时实现了RandomAccess和Serializable接口
         * AbstractList 这个类定义的add remove set 等方法是直接拋异常的： throw new UnsupportedOperationException();
         * 解决： List<String> stringList = new ArrayList<>(Arrays.asList(arr));
         */
        //数组转list
        String[] arr = {"aa","bb","cc","dd"};
        List<String> stringList =  Arrays.asList(arr);

    }
}
