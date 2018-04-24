package thread.Kfc;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 **/
public class Food {
    String name="";
    //通过构造方法传入食物的名字
    public Food(String name) {
        this.name=name;
    }
    //get、set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
