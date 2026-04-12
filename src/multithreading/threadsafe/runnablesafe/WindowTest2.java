package multithreading.threadsafe.runnablesafe;

/*
 * Runnable接口
 * 同步方法
 * */

public class WindowTest2 {
    public static void main(String[] args) {
        SaleTicket1 s = new SaleTicket1();

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

class SaleTicket1 implements Runnable {
    int ticket = 100;
    boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {

            show();

        }
    }

    public synchronized void show() {//此时同步监视器为this，不能改变
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":正在出售第" + ticket + "张票");
            ticket--;
        } else {
            isFlag = false;
        }
    }
}

