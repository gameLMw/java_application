package generic.use;

/*
 * 自定义泛型类\自定义泛型接口:
 *      class A<T>{}
 *
 *      interface B<T1,T2>{}
 *
 * 泛型参数在指明时不能使用基本数据类型，但可以使用包装类替代基本数据类型
 * */

import org.junit.jupiter.api.Test;

public class _02 {
    @Test
    public void test1() {
        Demo<String> demo = new Demo<>();
        demo.setT("AA");
        demo.setI(10);
        System.out.println(demo.getT());
        Demo1 demo1 = new Demo1();
        demo1.setI(10);
    }
}
