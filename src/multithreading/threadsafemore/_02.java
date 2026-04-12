package multithreading.threadsafemore;

/*
 * 死锁：两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们将无法推进下去
 *       如：A进程占用资源R1，B进程占用资源R2，A进程请求资源R2，B进程请求资源R1，两个进程相互等待，都无法继续推进下去，就形成死锁
 *
 * 发生死锁的原因：
 * 1. 互斥条件:
 *              含义：资源是独占的，同一时刻只能被一个线程占用
 *              说明：如果一个资源已经被线程 A 占用，其他线程就不能访问这个资源，只能等待
 *              例子：打印机、文件写操作、同步锁等都是互斥资源
 * 2. 占用且等待:
 *              含义：线程已经持有了至少一个资源，但还在等待获取其他线程持有的额外资源
 *              说明：线程不释放已占有的资源，同时请求新的资源
 *              例子：线程 A 持有锁 L1，又去请求锁 L2；线程 B 持有锁 L2，又去请求锁 L1
 * 3. 不可抢占:
 *              含义：资源不能被强制从持有者手中抢走，只能由持有者主动释放
 *              说明：其他线程不能强行剥夺某个线程已经占有的资源
 *              例子：synchronized 锁只能由获得锁的线程主动释放，JVM 不会强制回收
 * 4. 循环等待:
 *              含义：存在一个线程等待的循环链，每个线程都在等待下一个线程所占有的资源
 *              说明：形成环形依赖关系
 *              例子：
 *                  线程 A 等待线程 B 持有的资源
 *                  线程 B 等待线程 C 持有的资源
 *                  线程 C 等待线程 A 持有的资源
 * 以上四个条件都具备，则称该系统存在死锁
 *
 * 避免死锁：
 * 针对条件1：互斥条件基本无法破坏，因为线程需要通过互斥解决安全问题
 * 针对条件2：可以考虑一次性申请所有所需的资源，这样就不存在等待的问题。
 * 针对条件3：占用部分资源的线程在进一步申请其他资源时，如果申请不到，就主动释放掉已经占用的资源。
 * 针对条件4：可以将资源改为线性顺序。申请资源时，先申请序号较小的，这样避免循环等待问题。
 * */

public class _02 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {

                    s1.append("a");//append()方法，返回StringBuffer对象本身
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (s2) {

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s1) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
    }
}
