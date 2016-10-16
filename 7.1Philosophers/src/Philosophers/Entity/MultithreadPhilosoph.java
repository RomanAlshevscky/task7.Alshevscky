package Philosophers.Entity;

import java.util.InputMismatchException;
import java.util.concurrent.locks.Lock;

/**
 * Created by User on 16.10.2016.
 */
public class MultithreadPhilosoph extends Philosoph implements Runnable {

    protected volatile boolean stopFlag = false;
    protected Lock leftLock;
    protected Lock rightLock;
    protected volatile boolean hungry = false;

    public void setStopFlag(boolean value){
        stopFlag = value;
    }

    public MultithreadPhilosoph(int position, Fork left, Fork right, Lock leftLock,
                         Lock rightLock) {
        super(position, left, right);
        this.leftLock = leftLock;
        this.rightLock = rightLock;
    }

    public void run() {
        while (!stopFlag) {
            think();
            hungry = true;
            stillHunger();
        }
        System.out.println("{Philosopher " + getPosition() + "] stopped");
    }

    /**
     * Trying lock shared object iterations
     */
    private void stillHunger(){
        while (hungry) {
            try {
                if (tryToEat(leftLock, rightLock))
                    tryToEat(rightLock, leftLock);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void printFirstForkLocked(){
        System.out.println("[Philosopher " + getPosition()
                + "] took first fork");
    }

    private void printSecondForkLocked(){
        System.out.println("[Philosopher " + getPosition()
                + "] took second fork");
    }

    private boolean tryToEat(Lock firstLock, Lock secondLock) throws InterruptedException {
        //Lock first object, or wait for it
        firstLock.lock();
        try {
            printFirstForkLocked();
            //try to lock second object
            if (secondLock.tryLock()) {
                try {
                    printSecondForkLocked();
                    eat();
                    hungry = false;
                } finally {
                    secondLock.unlock();
                }
                //If second object was locked by other thread -
                //waiting random time, before unlock first object to
                //avoid deadlock
            } else {
                Thread.sleep(getRandomInt(10));
            }
        } finally {
            firstLock.unlock();
        }
        return hungry;
    }
}

