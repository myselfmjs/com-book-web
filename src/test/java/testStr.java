import org.apache.commons.lang.StringUtils;

/**
 * Created by majunsheng on 2017/6/27.
 */
public class testStr {

    public static void main(String[] args) {
        String str = "abcdefg";
        String stripStr = "abfg";
        boolean empty = StringUtils.isEmpty(str); //判断是否为空 为空标准  str ==null  或 str.length = 0
        String strip = StringUtils.strip(str, stripStr); //去除str两端 在 stripStr 中的字符 如果str 为空 则返回str
        System.out.println(empty);
        System.out.println(strip);

        String str1 = "abcd";
        String str2 = "ABCD";
        boolean equals = StringUtils.equals(str1, str2);//判读两个字符串是否相当  为空也相等
        boolean ignoreCase = StringUtils.equalsIgnoreCase(str1, str2);//判断..  不区分大小写
        System.out.println(equals);
        System.out.println(ignoreCase);

        String str3 = " ";
        System.out.println(StringUtils.isBlank(str3)); //判断是否为空  由空格符组成 /n/t/f/r 都是空  /b 不是
        System.out.println(StringUtils.isEmpty(str3));  //注意 isEmpty() 与 isBlank() 区别
    }
}
