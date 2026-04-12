package multithreading.threadsafemore;

/*
 * 实现线程安全的懒汉式
 * */

public class _01 {

    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                b1 = Bank.getInstance();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}


class Bank {

    private Bank() {
    }

//    private static Bank instance = null;

    //避免指令重排
    private static volatile Bank instance = null;

    //实现线程安全方法1
//    public static synchronized Bank getInstance() {//同步监视器默认为Bank.class
//        if (instance == null) {
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            instance = new Bank();
//        }
//        return instance;
//    }

    //实现线程安全方法2
//    public static  Bank getInstance() {
//        synchronized (Bank.class) {
//            if (instance == null) {
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //实现线程安全方法3，相较于方法1，2，方法3的效率更高。为了避免指令重排，使用volatile关键字
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
