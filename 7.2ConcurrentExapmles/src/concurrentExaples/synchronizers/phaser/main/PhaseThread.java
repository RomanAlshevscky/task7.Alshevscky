package concurrentExaples.synchronizers.phaser.main;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }
    public void run(){

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " пропускает фазу " + phaser.getPhase());
        phaser.arrive();

        System.out.println(name + " заканчивает работу на фазе " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
