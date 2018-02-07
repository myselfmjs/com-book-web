package basics.duotai;

/**
 * JAVA 多态
 */
public class A {

    public String show (D obj){
        return "A--D";
    }
    public String show (A obj){
        return "A--A";
    }
}
