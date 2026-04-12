package multithreading.xain_cheng_chuang_jian;

/*
 * 多线程创建方式4：线程池（jdk5.0新增）
 * 此方式的好处：
 * 提高了程序执行的效率。（因为线程已经提前创建好了)
 * 提高了资源的复用率。（因为执行完的线程并未销毁，而是可以继续执行其他的任务）
 * 可以设置相关的参数，对线程池中的线程的使用进行管理
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class _04 {
    public static void main(String[] args) {
        //1.创建指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性
//        System.out.println(service1.getCorePoolSize());//ThreadPoolExecutor
        service1.setCorePoolSize(50);//设置线程池的线程数上限

        //2.执行指定的线程任务，需要创建实现Runnable接口或Callable接口的实现类对象
        service.execute(new NumberThread());//适用用于Runnable接口创建的线程
        service.execute(new NumberThread1());//适用用于Runnable接口创建的线程

        //service.submit(Callable callable);//适用用于Callable接口创建的线程

        //3.关闭线程池
        service.shutdown();
    }
}

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}