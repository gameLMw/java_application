package multithreading.xain_cheng_chuang_jian;

/*
 * 多线程创建方式3：实现Callable接口(jdk1.5)
 *
 * 与之前的方式的对比：与Runnable方式的对比的好处
 * call()可以有返回值，更灵活
 * call()可以使用throws的方式处理异常，更灵活
 * Callable使用了泛型参数，可以指明具体的call（）的返回值类型，更灵活
 *
 * 缺点: 如果在主线程中需要获取分线程calL()的返回值，则此时的主线程是阻塞状态的。
 * */

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class _03 {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //4.创建FutureTask类对象，将Callable接口实现类的对象作为构造器参数传递
        FutureTask futureTask = new FutureTask(numThread);

        //5.将FutureTask对象作为Thread类的构造器的参数，创建Thread类的对象，并调用start()方法启动线程
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            //6.获取Callable接口返回的结果
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

//1.创建一个实现Callable接口的实现类
class NumThread implements Callable {
    //2.实现call()方法，将此线程需要执行的任务，在call()方法中完成
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
