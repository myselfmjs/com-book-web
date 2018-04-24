package string;


import org.apache.commons.lang.StringUtils;

/**
 * StringUtilsTest
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        String str = "  ";

        System.out.println("trim----: " +  StringUtils.trim(str));
        System.out.println("strip----:  " + StringUtils.strip(str));

        System.out.println("trim null----: " +  StringUtils.trim(null));
        System.out.println("strip null----:  " + StringUtils.strip(null));
        System.out.println();

        String strip = "abdcfabgabc";
        System.out.println("stripStart=---" + StringUtils.stripStart(strip,"abc"));
        System.out.println("stripEnd----" + StringUtils.stripEnd(strip,"abc"));
    }
}
