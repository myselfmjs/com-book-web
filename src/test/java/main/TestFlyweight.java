package main;

import factory.ArtistFactory;
import pojo.Artist;

/**
 * Created by majunsheng on 2017/3/28.
 */
public class TestFlyweight {
    public static void main(String[] args) {
        ArtistFactory artistFactory =new ArtistFactory();
        Artist artist = artistFactory.getArtist("男");
        artist.setName("周杰伦");
    }
}
