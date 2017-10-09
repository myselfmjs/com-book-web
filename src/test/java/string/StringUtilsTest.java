package string;


import org.apache.commons.lang.StringUtils;

/**
 * StringUtilsTest
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        String str = "  ";
        String strNull = null;

        System.out.println("trim----: " +  StringUtils.trim(str));
        System.out.println("strip----:  " + StringUtils.strip(str));

        System.out.println("trim null----: " +  StringUtils.trim(strNull));
        System.out.println("strip null----:  " + StringUtils.strip(strNull));
    }
}
