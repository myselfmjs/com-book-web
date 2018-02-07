package basics.jingtai;

public class Person {

    private static int userNum = 0;

    public Person(){
        userNum ++;
    }


    public static void main(String[] args) {
        Person p1 = new Person();

        Person p2 = new Person();

        System.out.println(Person.userNum);
    }
}
