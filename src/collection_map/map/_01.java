package collection_map.map;

/*
 * java.util.Map接口：存储一对一对的数据（key-value键值对，函数，y=f(x)）
 *       HashMap:主要实现类,线程不安全，效率高;可以添加null的key和value值；底层使用数组+单向链表+红黑树（jdk8）
 *               LinkedHashMap:hashMap的子类，在HashMap使用数据结构的基础上，增加了一对双向链表，用于记录添加的元素的先后顺序
 *                              进而在遍历元素时，可以按照添加顺序展示
 *                              对于频繁遍历操作，建议使用LinkedHashMap
 *       TreeMap：底层使用红黑树存储；可以按照添加的key-value中的key元素的指定的属性的大小顺序进行遍历；需要考虑1.自然排序2.定制排序
 *       Hashtable:古老实现类,线程安全，效率低;不可以添加null的key或value值；底层使用数组+单向链表
 *               Properties：其key和value都是String类型。常用于处理属性文件
 *
 * HashMap中元素的特点：
 *  HashMap中的所有key彼此之间是不可重复的，无序的。所有的key就构成一个Set集合。key所在的类要重写hashCode()和equals()
 *  HashMap中的所有value彼此之间是可重复的，无序的。所有的value就构成一个Collection集合。value所在的类要重写equals()
 *  HashMap中的一个key-value，就构成了一个Entry。
 *  HashMap中的所有Entry彼此之间是不可重复的，无序的。所有的Entry就构成一个Set集合
 * */

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class _01 {
    @Test
    public void test1() {
        Map map = new HashMap();

        map.put(null, null);
        map.put("AA", 123);
        map.put("AA", 123);
        map.put("BB", 123);

        System.out.println(map);
    }

    @Test
    public void test2() {
        Map map = new Hashtable();

        map.put("AA", 123);

        System.out.println(map);
    }

}