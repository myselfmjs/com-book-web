package map;

import java.util.*;

/**
 * Created by majunsheng on 2017/3/29.
 * Map的遍历
 */
public class entryMap {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("一","1");
        m.put("二","2");
        valueMap(m);
        keyMap(m);
        entryMap(m);
    }

    /**
     * 获取Map的Value
     * @param map
     */
    private static void valueMap(Map map){
        Collection<String> values = map.values();
        System.out.println("Value:"+values.toString());
    }

    /**
     * 获取Map的Key
     * @param map
     */
    private static void keyMap(Map map){
        Set<Integer> set = map.keySet();
        System.out.println("Key:"+set.toString());
    }

    /**
     * 获取Map实体，遍历键值对
     * @param map
     */
    private static void entryMap(Map map){
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("entry: key:"+entry.getKey()+";value:"+entry.getValue());
        }
    }
}
