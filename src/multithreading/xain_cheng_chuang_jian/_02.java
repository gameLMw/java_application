package multithreading.xain_cheng_chuang_jian;

/*
 * 线程创建方法2：实现Runnable接口
 * 1.创建一个实现Runnable接口的类
 * 2.实现Runnable接口中的run()方法，将线程要执行的任务放在run()方法中
 * 3.创建当前Runnable接口的实现类对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
 * 5.通过Thread类的实例调用start()方法启动线程,start()方法1.启动线程.2.调用当前run()方法
 * */

/*
* 方法1与方法2的区别：
* 共同点：1. 启动线程，都是调用start()方法
*           2. 创建的线程对象，都是创建Thread类或其子类的实例
* 不同点：一个是Thread类的继承，一个是Runnable接口对象
*           建议使用Runnable接口
*               Runnable接口好处：
*                   1. 实现的方式，避免了单继承的局限性
*                   2. 更适合处理有共享数据的场景，
*                       方法1中，每创建一个线程，都需要创建一个Runnable接口的实现类对象，
*                       方法2中，如"p"这个类中的数据是共享的
*                   3. 实现代码和数据分离
* 联系：public class Thread implements Runnable (代理模式)
* */

public class _02 {
    public static void main(String[] args) {
        //3.创建当前Runnable接口的实现类对象
        EvenNumber p = new EvenNumber();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
        Thread t1 = new Thread(p);
        //5.通过Thread类的实例调用start()方法启动线程
        t1.start();

        //方法3
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0)
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        });
        t2.start();
    }
}

//1.创建一个实现Runnable接口的类
class EvenNumber implements Runnable {
    //2.实现Runnable接口中的run()方法，将线程要执行任务放在run()方法中
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

