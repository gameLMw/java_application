package collection_map.collection.set;

/*
 * TreeSet：底层使用红黑树存储，可以按照添加的元素的指定属性的大小顺须进行遍历
 *
 * 添加到TreeSet中的元素的要求：添加到TreeSet中的元素必须时同一个类型的对象，否则会报ClassCastException异常
 *
 * 判断数据是否相同的标准：
 *      不是考虑hashCode()和equals()方法,所以不用重写equals()和hashCode()方法
 *      自然排序：按照升序进行排序
 *      定制排序：按照指定属性进行排序，需要实现Comparable接口并重写compareTo()或compare()方法
 *              如果compareTo()或compare()返回值为0，则认为两个对象相等
 * */

import collection_map.Person;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class _02 {

    //自然排序
    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        set.add("AA");
        set.add("CC");
        set.add("BB");
        set.add("EE");
        set.add("DD");
//        set.add(123);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    //自然排序
    @Test
    public void test2() {
        TreeSet set = new TreeSet();
        set.add(new Person("张三", 12));
        set.add(new Person("王五", 14));
        set.add(new Person("张三", 12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    public void test3() {
        TreeSet set = new TreeSet();
        set.add(new treeSetDemo("张三", 50));
        set.add(new treeSetDemo("张三", 12));
        set.add(new treeSetDemo("张三", 13));
        set.add(new treeSetDemo("张三", 22));
        set.add(new treeSetDemo("张三", 12));
        set.add(new treeSetDemo("王五", 14));
        set.add(new treeSetDemo("王五", 12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class treeSetDemo extends Person implements Comparable {

    public treeSetDemo(String 王五, int i) {
        super(王五, i);
    }

    public treeSetDemo() {
        super();
    }

    //例：按照年龄进行排序
    /*
     * 核心比较逻辑：this.age - t.age
     *   返回负数：当前对象年龄 < 比较对象年龄 → 当前对象排在前面
     *   返回零：当前对象年龄 = 比较对象年龄 → 两者相等（TreeSet会视为重复元素）
     *   返回正数：当前对象年龄 > 比较对象年龄 → 当前对象排在后面
     * */
//    @Override
//    public int compareTo(Object o) {
//        if (this == o) {
//            return 0;
//        }
//
//        if (o instanceof treeSetDemo) {
//            treeSetDemo t = (treeSetDemo) o;
//            return this.age - t.age;
//        }
//
//        throw new RuntimeException("输入的类型不匹配");
//    }


    //先比较年龄从小到大，年龄相等，再比较姓名，姓名从小到大
    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof treeSetDemo) {
            treeSetDemo t = (treeSetDemo) o;
            int value = this.age - t.age;
            if (value != 0) {
                return value;
            }
            return this.name.compareTo(t.name);
        }

        throw new RuntimeException("输入的类型不匹配");
    }
}
