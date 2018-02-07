package basics.Neibulei;



public class OuterClass {

    public void display(final String name, String age){

        class InnerClass{
            void display(){
                System.out.println(name);
            }
        }

        new InnerClass().display();
    }

    public static void main(String[] arg){
        OuterClass out = new OuterClass();
        out.display("123","321");

    }

}