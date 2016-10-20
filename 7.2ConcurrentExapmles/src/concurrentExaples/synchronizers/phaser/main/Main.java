package concurrentExaples.synchronizers.phaser.main;


import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "Поток 1")).start();
        new Thread(new PhaseThread(phaser, "Поток 2")).start();
        new Thread(new PhaseThread(phaser, "Поток 3")).start();

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}


