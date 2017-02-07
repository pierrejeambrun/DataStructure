package All;

import sun.misc.Lock;

import java.util.ArrayList;

public class TrainThread {
    int count;

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        Lock lock = new Lock();
        TrainThread trainThread1 = new TrainThread();
        TrainThread trainThread2 = new TrainThread();

        Runnable runnableLock = () -> {
            int i = 0;
            while (i < 10000) {
                try {
                    lock.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                trainThread1.count++;
                i++;
                lock.unlock();
            }
        };
        Runnable runnableSynchronizedMethod = trainThread2::count;
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(runnableLock);
            Thread thread2 = new Thread(runnableLock);
            Thread thread3 = new Thread(runnableSynchronizedMethod);
            Thread thread4 = new Thread(runnableSynchronizedMethod);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            try {
                thread1.join();
                thread2.join();
                thread3.join();
                thread4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lock : " + trainThread1.count);
            System.out.println("Synchronized : " + trainThread2.count);
            trainThread1.count = 0;
            trainThread2.count = 0;
        }
        System.out.println("-----------------------------------");
        desynchronizedThread();
    }


    public static void desynchronizedThread() {
        TrainThread trainThread = new TrainThread();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                trainThread.count++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                trainThread.count++;
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(trainThread.count);
    }

    public synchronized void count() {
        for (int i = 0; i < 10000; i++) {
            this.count++;
        }
    }
}
