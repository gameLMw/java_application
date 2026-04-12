package collection_map.collection.list;

/*
 * list接口：存储有序的，可重复的数据
 *
 * 方法；
 *   1. Constructor中的方法
 *   2. 针对于List是有序的，有索引的，增加的方法：
 *           增：
 *               add(Object obj):添加元素
 *               addAll(Collection c):添加c集合中的所有元素
 *           删:
 *               remove(Object obj):删除指定的元素，返回删除的元素
 *               remove(int index):删除指定索引的元素，返回删除的元素
 *           改:
 *               set(int index,Object obj):将指定索引的元素设置为obj
 *           查:
 *               get(int index):获取指定索引的元素
 *           插入；
 *               add(int index,Object obj):将obj添加到指定索引的元素
 *               addAll(int index,Collection c):将c集合中的所有元素添加到指定索引的元素
 *           长度:
 *               size():获取元素个数
 *           遍历:
 *               iterator():获取迭代器对象
 *               增强for循环
 *               一般for循环
 *           等等
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class _01 {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();

        //add
        list.add("张三");
        list.add(123);

        //addAll
        list.addAll(list);
        System.out.println(list);

    }
}
