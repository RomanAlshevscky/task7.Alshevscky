package concurrentExaples.locks.readWriteLock.main;

import concurrentExaples.locks.readWriteLock.buffer.Buffer;
import concurrentExaples.locks.readWriteLock.thread.GetThread;
import concurrentExaples.locks.readWriteLock.thread.PutThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();

        new Thread(new GetThread(1,b)).start();
        new Thread(new GetThread(2,b)).start();
        new Thread(new PutThread(3,b)).start();
        new Thread(new PutThread(4,b)).start();
    }
}
