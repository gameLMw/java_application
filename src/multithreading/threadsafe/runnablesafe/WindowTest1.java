package multithreading.threadsafe.runnablesafe;

/*
 * 继承
 * 使用同步代码块解决线程安全问题
 * */

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
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {//this不唯一
//            synchronized (obj）{//用static修饰的对象，所有对象共用一个锁
            synchronized (Window1.class) {//结构：Class clz = Window1.class;(反射）
                if (ticket > 0) {
                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
