package com.tin.example.lock;

/**
 * 线程死锁测试
 *
 * 线程A持有锁1 ,想去拿锁2, 线程B持有锁2, 想去拿锁1, 但是此时释放都不释放自己的锁, 那么就会进入无尽的阻塞.
 * 锁的特性是只能被一个线程所拥有
 */
public class LockDemo {
    String name;

    LockDemo(String name) {
        this.name = name;
    }

    public synchronized void goBuying(LockDemo lockDemo) {
        System.out.println(name + " go to buy.");
        synchronized (lockDemo) {
            System.out.println(lockDemo.name + " go to buy.");
        }
    }


    public static void main(String[] args) {
        LockDemo A = new LockDemo("Tom");
        LockDemo B = new LockDemo("allen");
        Thread threadA = new Thread(new LockRunnable(A, B));
        Thread threadB = new Thread(new LockRunnable(B, A));
        threadA.start();
        threadB.start();

    }

    static class LockRunnable implements Runnable {
        private LockDemo A;
        private LockDemo B;

        LockRunnable(LockDemo A, LockDemo B) {
            this.A = A;
            this.B = B;
        }

        public void run() {
            while (true) {
                A.goBuying(B);
            }
        }
    }

}
