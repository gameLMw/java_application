package multithreading.threadsafemore;

/*
 * 继承
 * ReentrantLock
 * 1.创建ReentrantLock实例，需要确保多个线程共用同一个ReentrantLock实例，声名为static final
 * 2.锁定对共享资源的调用
 * 3.释放对共享资源的锁定
 *
 * synchronized和Lock比较
 * 1. synchronized需要在一对{}后，释放同步监视器的调用
 *      Lock是通过调用lock()和unlock()方法锁定和释放对共享资源的锁定
 * 2. Lock作为接口，提供了多种实现类，更灵活
 * */

import java.util.concurrent.locks.ReentrantLock;

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window1 extends Thread {
    private static int ticket = 100;

    // 1.创建ReentrantLock实例，需要确保多个线程共用同一个ReentrantLock实例，声名为static final
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.锁定对共享资源的调用
                lock.lock();
                if (ticket > 0) {
                    System.out.println(getName() + ": 票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {//finally代码块，保证锁的释放
                //3.释放对共享资源的锁定
                lock.unlock();
            }
        }
    }
}
