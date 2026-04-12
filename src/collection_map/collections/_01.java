package collection_map.collections;

/*
 * collections是一个操作Set,List和Map等集合的工具类
 *
 * 方法：
 *   1. addAll(Collection target,Collection source):把source集合中的元素添加到target集合中
 *   2. fill(List list,Object obj):用obj填充list集合
 *   3. replaceAll(List list,Object oldObj,Object newObj):把list集合中，所有等于oldObj的元素替换成newObj
 *   4. copy(List dest,List src):把src集合中的元素复制到dest集合中
 *   5. binarySearch(List list,Object obj):对list集合进行二分查找，返回索引值
 *   等等
 *
 * collections和collection的区别
 *   collection:集合框架用于存储一个一个元素的接口，有分为List,Set,Map等子接口
 *   collections:集合框架的工具类，用于操作集合
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class _01 {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add("张三");

    }
}
