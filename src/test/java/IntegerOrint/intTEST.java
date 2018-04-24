package IntegerOrint;


/**
 * 装箱于拆箱测试
 */
public class intTEST {

    public static void main(String[] args) {

        /**
         *装箱调用的是 valueOf() 方法
         * Integer 的 valueOf() 方法 有个值域 -128 ~127
         * 在该值域的值是同一个，否则会重新创建一个Integer
         * 例子： i3 != i4
         */


        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println();

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;

        System.out.println(d1 == d2);
        System.out.println(d3 == d4);
        System.out.println();


        /**
         * 低精度与高精度计算会自动转为高精度，
         * 装箱后都是对象，所以 equals 比较是False
         *
         */


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));


        /**
         * 测试
         * == 于 equals
         *
         */

        Value v1 = new Value();

        Value v2 = new Value();

        v1.i = 100;
        v2.i = 300;
        System.out.println("测试 == 于 equals  ---------------------------");
        System.out.println(v1 == v2);

        //这里调用的是Value 中的equals方法 如果没有重写则调用的是Object中的equals方法
        //Object中的 equals方法本质上还是用 == 比较的   结果 false
        System.out.println(v1.equals(v2));
    }


     static class Value{

        int i;


         /**
          * 重写Object的 equals方法
          * 自定义equals规则
          *
          * @param obj
          * @return
          */
        @Override
         public boolean equals(Object obj){
            if (obj == null){
                return false;
            }else if (obj instanceof Value){
                Value v = (Value) obj;
                Value v2 = this;
                if (v.i == this.i){
                    return  true;
                }
            }
            return false;
        }
    }

}
