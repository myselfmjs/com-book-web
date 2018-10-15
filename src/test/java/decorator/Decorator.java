package decorator;

/**
 * Decorater 抽象装饰者
 * @Author: majunsheng
 * @Date: 2018/10/15
 **/
public abstract class Decorator implements Person {

    protected  Person person;

    public void setPerson(Person person){
        this.person = person;
    }

    public void eat(){
        person.eat();
    }
}
