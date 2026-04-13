package collection_map.collection;

/*
 * Collection接口：存储一个一个的数据
 * 1. add(Object obj):添加元素
 * 2. addAll(Collection c):添加c集合中的所有元素到当前集合中
 * 3. size():获取当前集合的元素个数
 * 4. isEmpty():判断当前集合是否为空
 * 5. contains(Object obj):判断当前集合中是否包含obj
 * 等等
 *
 * collection中添加元素的要求
 * 集合存储元素，要求元素必须是对象，对象中必须重写equals和hashCode方法
 * 原因：
 * 因为Collection集合存储元素，要调用Object类中的equals方法进行比较
 *
 * Iterator迭代器：
 * 用来遍历集合元素
 * */

import collection_map.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class _01 {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add("张三");
        coll.add(123);
        coll.add(new Person("张三", 12));
//        Person p = new Person("张三", 12);
//        coll.add(p);
//        coll.add(new String("王五"));
        System.out.println(coll);
//        System.out.println(coll.size());

//        Collection c1 = new ArrayList();
//        c1.add("李四");
//        c1.add(456);
//        coll.addAll(c1);
//        System.out.println(c1);
//        System.out.println(c1.size());
//        System.out.println(coll);
//        System.out.println(coll.size());
//
//        c1.add(coll);
//        System.out.println(c1);
//        System.out.println(c1.size());

//        System.out.println(coll.isEmpty());
//
//        System.out.println(coll.contains(new Person("张三", 12)));
//        System.out.println(coll.contains(new String("王五")));

        //获取迭代器对象
        Iterator iterator = coll.iterator();

        //方式1：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());


        //方式2：
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式3：
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //增强for循环
        //底层使用的迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
}


