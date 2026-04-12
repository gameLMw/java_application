package multithreading.communication;

/*
 * 线程的通信
 *当我们需要多个线程来共同完成一件任务，并且我们希望他们有规律的执行，那么多线程之间需要一些通信机制，可以协调它们的工作，以此实现多线程共同操作一份数据。
 *
 * 方法：
 * wait()：线程一旦执行此方法，就进入等待状态。同时，会释放对同步监视器的调用
 * notify()：一旦执行此方法，就会唤醒被wait()的线程中优先级最高的那一个线程。
 *          （如果被wait()的多个线程的优先级相同随机唤醒一个）。
 *            被唤醒的线程从当初被wait的位置继续执行。
 * notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * sleep()与wait()方法区别：
 * 相同点：一旦执行，当前线程都会进入阻塞状态
 * 不同点：
 * 1. 声明的位置：wait():声明在0bject类中
 *                sleep():声明在Thread类中，静态的
 * 2.使用的场景不同：wait():只能使用在同步代码块或同步方法中
 *                  sleep():可以在任何需要使用的场景
 * 3.使用在同步代码块或同步方法中：wait(）：一旦执行，会释放同步监视器
 *                              sleep（）:一旦执行，不会释放同步监视器
 * 4.结束阻塞的方式：wait()：到达指定时间自动结束阻塞或通过被notify唤醒，结束阻塞
 *                  sleep()：到达指定时间自动结束阻塞
 * */

public class _01 {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();

        Thread t1 = new Thread(printNumber);
        Thread t2 = new Thread(printNumber);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class PrintNumber implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (number <= 100) {

                    notify();

                    try {
                        Thread.sleep(100);//不会释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        wait();//线程一旦执行此方法，就会阻塞，同时释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    break;
                }
            }
        }
    }
}
