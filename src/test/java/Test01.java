import java.util.*;

public class Test01 {
    public static void main(String[] args) {

      /* Date date =  getLastDayOfQuarter(2018,2);
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));*/


      Menu menu01 = new Menu("01","a");
      Menu menu02 = new Menu("02","b");
      Menu menu03 = new Menu("03","c");
      Map<String,Menu> map = new HashMap();
      map.put(menu01.getNum(),menu01);
      map.put(menu02.getNum(),menu02);
      map.put(menu03.getNum(),menu03);
    }


    /**
     * 获取某季度得最一天
     * @param year　年
     * @param quarter　季度
     * @return
     */
    public static Date getLastDayOfQuarter(int year, int quarter){
        Calendar c = new GregorianCalendar();

        int month = 0;
        switch (quarter) {
            case 1:
                month = 3-1;
                break;
            case 2:
                month = 6-1;
                break;
            case 3:
                month = 9-1;
                break;
            case 4:
                month = 12-1;
                break;
            default:
                month = c.get(Calendar.MONTH);
                break;
        }

        return getLastDayOfMonth(year, month);
    }

    /**
     * 获取某月得最后一天
     * @param year 年
     * @param month 月
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month){
        Calendar c = new GregorianCalendar();

        c.set(year, month, 1);
        c.roll(Calendar.DATE, -1);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }


    public static void ScanSort(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list, new Comparator<Integer>() {

                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }

            System.out.println();

        }
    }

}




