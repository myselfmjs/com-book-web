package heapStack;

/**
 * Created by majunsheng on 2017/7/13.
 * 关于堆栈
 */
public class HeapStack {
    public static void main(String[] args) {
        String str = new String("abc");
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = str.intern();  //返回字符串对象的规范表示形式
        String str5 = str1.intern();
       /* System.out.println(str == str1);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str == str3);
        System.out.println(str == str4);
        System.out.println(str1 == str5);*/


       String h = new String("1") + new String("1");
       h.intern();
       String hh = "11";
        System.out.println(hh == h);
    }
}
