package pojo;

/**
 * Created by majunsheng on 2017/3/28.
 *  作为共享的ConcreteFlyweight
 */
public class Artist {

    private String name;

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
