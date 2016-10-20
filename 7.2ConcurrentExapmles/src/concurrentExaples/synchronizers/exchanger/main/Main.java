package concurrentExaples.synchronizers.exchanger.main;

import concurrentExaples.synchronizers.exchanger.student.Student;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Student(1)).start();
        Thread.sleep(100);
        new Thread(new Student(2)).start();

    }
}
