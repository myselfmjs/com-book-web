package basics.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试asList的特性
 *
 */
public class asList {

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7};

        List list = Arrays.asList(arr);
        System.out.println(list.size());
        //这里list.size()是1, 查看源码可得asList参数(T... a) 是一个变长参数，而8中基本数据类型是不可作为泛型参数的。解决方法 转为Integer类型


        String arrStr[] = {"1","2","3","4"};

        List strList = Arrays.asList(arrStr);
        //strList.add("5");
        //在这里运行时会报错，UnsupportedOperationException 不支持请求操作，从某种意义上来说就是不支持add()操作，源码分析 asList 返回的是return>(a);   这个ArrayList 是Arrays的一个内之类，而且没有定义add()方法，查看其父类有定义 但需要子类实现。所以在这并不能 new ArrayList<T用add方法。解决方法：将asList后的list放到一个新的List中
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(strList);
        arrayList.add("5");
        arrayList.add("");
        arrayList.add("");
        System.out.println(arrayList.toString());

    }
}
