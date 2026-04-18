package new_features.lambda;

/*
 * Lambda
 *
 * ->: lambda操作符
 * ->的左边：lambda形参列表,对应着要重写的接口中的抽象方法的形参列表
 * ->的右边：lambda方法体,对应着要重写的接口中的抽象方法的方法体
 *
 * 函数式接口：只包含一个抽象方法的接口
 *
 * 四大函数式接口：                         用途
 * 1.Consumer<T>: 消费型接口         对类型为T的对象进行操作，void accept(T t);
 * 2.Supplier<T>: 供给型接口         返回类型为T的对象，T get();
 * 3.Function<T,R>: 函数型接口       对类型为T的对象进行操作，并返回R类型的对象，R apply(T t);
 * 4.Predicate<T>: 判断型接口        确定类型为T的对象是否满足某条件，并返回Boolean值，boolean test(T t);
 * */

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class _01 {
    @Test
    public void test() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        Runnable r1 = () -> System.out.println("hello world");
        r1.run();

        Fly fly = () -> System.out.println("flying...");
        fly.fly();
    }

    @Test
    public void test2() {
        Flying flying = new Flying() {
            @Override
            public void flying() {
                System.out.println("fly");
            }

            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        flying.flying();
        flying.run();
    }

    @Test
    public void test3() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int commpare1 = com1.compare(12, 21);
        System.out.println(commpare1);

        System.out.println("--------------------------------------------");

        // Lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int commpare2 = com2.compare(12, 21);
        System.out.println(commpare2);

        System.out.println("--------------------------------------------");

        // 方法引用
        Comparator<Integer> com3 = Integer::compare;
        int commpare3 = com3.compare(12, 21);
        System.out.println(commpare3);
    }

    @Test
    public void test4() {
        Fly f1 = () -> {
            System.out.println("flying...");
        };

        f1.fly();
        f1.run();
    }
}

