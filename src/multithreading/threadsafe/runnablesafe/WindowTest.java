package multithreading.threadsafe.runnablesafe;

/*
 * 使用同步代码块解决线程安全问题
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
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {//obj必须是唯一的
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":正在出售第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
