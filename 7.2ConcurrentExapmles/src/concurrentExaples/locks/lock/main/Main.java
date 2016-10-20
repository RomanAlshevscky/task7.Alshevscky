package concurrentExaples.locks.lock.main;

import concurrentExaples.locks.lock.buffer.Buffer;
import concurrentExaples.locks.lock.thread.GetThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();
        for(int i = 0; i < 5; i++){
            new Thread(new GetThread(i, b)).start();
        }
    }
}
