package generic.use;

/*
 * 泛型的使用
 * */


import generic.Person1;
import org.junit.jupiter.api.Test;

import java.util.*;

public class _01 {

    //没有泛型
    @Test
    public void test() {
        List list = new ArrayList();

        list.add(12);
        list.add(24);
        list.add(34);
        list.add(45);
        //问题1：类型不安全
        list.add("hello");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            //问题2：需要强转操作，繁琐，还有可能出现 ClassCastException 异常
            Integer it1 = (Integer) it.next();
            int i = it1;

            System.out.println(i);
        }
    }

    //使用泛型
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(24);
        list.add(34);
        list.add(45);
        //编译时期就会进行类型检查，保证数据的安全
//        list.add("AA");

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            //不需要进行强转
            Integer i = it.next();
            int i1 = i;
            System.out.println(i1);
        }
    }

    //在Map中使用泛型
    @Test
    public void test2() {
        //key-value
        HashMap<String, Integer> map = new HashMap<>();

        map.put("张三", 12);
        map.put("李四", 24);
        map.put("王五", 34);
        map.put("赵六", 45);
        map.put("田七", 56);

//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
//
        var entrySet = map.entrySet();
        var it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    //在比较器中使用泛型
    @Test
    public void test3() {
        TreeSet<Person1> set = new TreeSet<>();
        set.add(new Person1("abc", 24));
        set.add(new Person1("bcd", 12));
        set.add(new Person1("cde", 34));
        set.add(new Person1("def", 45));
        set.add(new Person1("efg", 56));

        Iterator<Person1> it = set.iterator();
        while (it.hasNext()) {
            Person1 p = it.next();
            System.out.println(p.name + "=" + p.age);
        }
    }
}
