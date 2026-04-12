package multithreading.fang_fa;

/*
 * 线程中的构造器
 * public Thread(): 分配一个新线程对象
 * public Thread(String name): 创建一个新线程对象，指定名称
 * public Thread(Runnable target): 指定创建的线程对象，实现Runnable接口中的run方法
 * public Thread(Runnable target, String name): 分配一个带有指定目标的新线程对象，并指定名称
 *
 * 线程中常用方法：
 * 1. start(): 启动线程，调用当前线程的run()方法
 * 2. run(): 线程要执行的任务，将线程要执行的任务放在run()方法中
 * 3. currentThread(): 获取当前正在执行的线程对象
 * 4. getName(): 获取当前线程的名称
 * 5. setName(): 设置当前线程的名称
 * 6. sleep(long millis): 线程休眠millis毫秒
 * 7. yield(): 静态方法，释放当前CPU资源，并把CPU资源让给其他线程
 * 8. join(): 当前线程调用此方法，则当前线程阻塞，并等待该线程执行完毕
 * 9. isAlive(): 判断当前线程是否存活
 *
 * 线程优先级：
 * 1. getPriority(): 获取当前线程的优先级
 * 2. setPriority(int newPriority): 设置当前线程的优先级(1-10)
 *      Thread类中的常量：
 *               MIN_PRIORITY: 1
 *               NORM_PRIORITY: 5
 *               MAX_PRIORITY: 10
 * */

public class _01 {
    public static void main(String[] args) {
        PrintNumber t1 = new PrintNumber("线程1");
        t1.setName("子线程");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ":" + i + "        " +
                        "优先级：" + Thread.currentThread().getPriority());
        }
    }
}

class PrintNumber extends Thread {

    public PrintNumber() {
    }

    public PrintNumber(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i + "        " +
                        "优先级：" + Thread.currentThread().getPriority());
        }
    }
}