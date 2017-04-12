package pojo;

/**
 * Created by majunsheng on 2017/3/28.
 * 设计模式：结构模式：Flyweight
 * 接口 Flyweight
 */

public class CD {

    /**
     * CD名称
     */
    private String title;

    /**
     * CD日期
     */
    private String data;

    /**
     * 演唱者
     */
    private Artist artist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
