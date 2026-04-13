package collection_map.collection.set;

/*
 * Set接口：存储无序的，不可重复的数据（集合）
 *          HashSet：set主要实现类;底层使用HashMap，即数组+单向链表+红黑树结构进行存储（jdk8中）
 *                LinkedHashSet:HashSet的子类；在现有的基础上添加了双向链表，用于记录添加元素的先后顺序,便于频繁查询操作
 *          TreeSet：底层使用红黑树存储，可以按照添加的元素的指定属性的大小顺须进行遍历
 *
 * 用于过滤重复数据
 *
 * 无序性 ！= 随机性
 *      根据添加的元素的哈希值，计算的其在数组中的存储位置，次位置不是依次排列的，表现为无须性
 *
 * 不可重复性：判断hashCode()得到的哈希值与equals()得到的结果，相同返回turn，则认为元素相同
 *
 * 添加到LinkedHashSet/HashSet中的元素的要求：
 * 元素所在的类中必须重写equals()和hashCode()方法，并保证二者的一致性：
 *      1. 一致性原则：如果两个对象通过equals()比较返回true，那么它们的hashCode()返回值必须相同。
 *      2. 哈希冲突处理：如果两个对象hashCode()返回值相同，equals()不一定返回true（哈希冲突）；但如果equals()返回true，hashCode()必须相同。
 *      3. 目的：确保HashSet/HashMap能正确识别重复元素，避免因哈希值不同导致重复存储逻辑上相等的对象。
 * */

import collection_map.Person;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _01 {
    @Test
    public void test1() {
        Set s1 = new HashSet();
        s1.add("AA");
        s1.add("BB");
        s1.add("BB");
        s1.add(123);
        s1.add(new Person("张三", 12));
        s1.add(456);

        Iterator i1 = s1.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }
}
