package multithreading.threadsafe.notsafe;

/*
 * 多线程安全问题
 *
 * 多线程卖票，出现了重票和错票
 *
 * 原因：在线程1在执行ticket的过程中，未结束的情况下，其他线程也执行了ticket，导致票数出现重复或者错乱
 *
 * Java解决多线程安全问题：使用线程的同步机制
 *
 * 方法1：同步代码块
 *      synchronized(同步监视器){
 *                  //需要同步的代码，即共享数据的代码
 *               }
 *      需要同步的代码，在被synchronized包裹后，使得一个线程在执行这些代码时，其他线程必须等待
 *      同步监视器：俗称锁，哪个线程获取了锁，哪个线程就能执行需要被执行的代码
 *                  可以使用任何一个类的对象充当，但是要求多个线程使用同一个对象作为锁
 *
 * 方法2：同步方法
 *          如果操作共享数据的代码完整声名在一个方法中，则把整个方法声名为同步方法
 *          非静态的同步方法，监视器默认是this，不能改变
 *          静态的同步方法，监视器默认是当前类本身（类名.class)
 *
 * synchronized好处：解决多线程安全问题
 * 弊端：多线程是串行执行，性能低
 * */

public class WindowTest {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SaleTicket implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":正在出售第" + ticket + "张票");
                ticket--;
            } else {
                break;
            }
        }
    }
}
