package Philosophers;

import Philosophers.Entity.MultithreadPhilosoph;
import Philosophers.Entity.Fork;

import java.lang.Thread;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Main {

    private static int count = 5;
    private static Thread[] threads = new Thread[count];
    private static MultithreadPhilosoph[] phils = new MultithreadPhilosoph[count];

    public static void main(String[] args) throws Exception {
        distribiteForks();
        startThreads();
        Thread.sleep(10000);
        stopThreads();
        printResult(phils);
    }

    private static void distribiteForks(){
        Fork last = new Fork();
        Fork left = last;
        Lock lastLock = new ReentrantLock();
        Lock leftLock = lastLock;
        for (int i = 0; i < count; i++) {
            Fork right = (i == count - 1) ? last : new Fork();
            Lock rightLock = (i == count - 1) ? lastLock : new ReentrantLock();
            phils[i] = new MultithreadPhilosoph(i, left, right, leftLock, rightLock);
            left = right;
            leftLock = rightLock;
        }

    }

    private static void stopThreads() throws Exception {
        for (MultithreadPhilosoph phil : phils) {
            phil.setStopFlag(true);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void startThreads(){
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(phils[i]);
            threads[i].start();
        }
    }

    public static void printResult(MultithreadPhilosoph[] phils){
        for (MultithreadPhilosoph phil : phils) {
            System.out.println("[Philosoph " + phil.getPosition() + "] ate "
                    + phil.getEatCount() + " times and waited " + phil.getWaitTime() + " ms");
        }
    }

}





