package multithreading.xain_cheng_chuang_jian;

/* 线程创建方法1：继承Thread类
 * 1.创建一个继承Thread类的子类
 * 2.重写线程类中的run()方法，将线程要执行的任务放在run()方法中
 * 3.创建当前Thread类的子类对象
 * 4.通过对象调用start()方法启动线程,start()方法1.启动线程.2.调用当前run()方法
 * */

public class _01 {
    public static void main(String[] args) {
        //3.创建当前Thread类的子类对象
        PrintNumber t1 = new PrintNumber();

        //4.通过对象调用start()方法启动线程
        t1.start();

        //main()所在线程
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

//1.创建一个继承Thread类的子类
class PrintNumber extends Thread {
    //2.重写线程类中的run()方法，将线程要执行的任务放在run()方法中
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}