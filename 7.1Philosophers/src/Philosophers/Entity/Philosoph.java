package Philosophers.Entity;

import java.util.Random;
import Philosophers.Entity.Fork;

/**
 * Created by User on 16.10.2016.
 */
public class Philosoph {

    private int position;
    private Fork left;
    private Fork right;
    private int eatCount = 0;
    private long waitTime = 0;
    private long startWait;
    private Random randomNumber = new Random();

    public int getPosition(){
        return position;
    }

    public int getRandomInt(int i){
        return randomNumber.nextInt(i);
    }

    public long getWaitTime(){
        return waitTime;
    }

    /**
     * Shared object picked up count.
     * @return
     */
    public int getEatCount(){
        return eatCount;
    }

    public Philosoph(int position, Fork left, Fork right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    /**
     * Hold shared objecct
     */
    public void eat() {
        waitTime += System.currentTimeMillis() - startWait;
        System.out.println("[Philosoph " + position + "] is eating");
        try {
            Thread.sleep(getRandomInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eatCount++;
        System.out.println("[Philosoph " + position + "] finished eating");
    }

    /**
     * Random time between holding shared object
     */
    public void think() {
        System.out.println("[Philosoph " + position + "] is thinking");
        try {
            Thread.sleep(getRandomInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Philosoph " + position + "] is hungry");
        startWait = System.currentTimeMillis();
    }
}
