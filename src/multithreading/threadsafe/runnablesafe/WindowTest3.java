package multithreading.threadsafe.runnablesafe;

/*
 * 继承
 * 使用同步方法解决线程安全问题
 * */

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window3 extends Thread {
    private static int ticket = 100;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            show();
        }
    }

    public void show() {//此时this不唯一
        synchronized (Window3.class) {
            if (ticket > 0) {
                System.out.println(getName() + ": 票号为：" + ticket);
                ticket--;
            } else {
                flag = false;
            }
        }
    }

}
