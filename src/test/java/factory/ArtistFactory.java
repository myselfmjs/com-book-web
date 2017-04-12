package factory;

import pojo.Artist;

import java.util.Hashtable;

/**
 * Created by majunsheng on 2017/3/28.
 * 用来制造可共享的ConcreteFlyweight:Artist
 */
public class ArtistFactory {

    Hashtable pool = new Hashtable();

    public Artist getArtist(String key){
        Artist result;
        result =(Artist) pool.get(key);
        //产生新的Artist
        if(result == null){
            result = new Artist(key);
            pool.put(key,result);
        }
        return  result;
    }
}
