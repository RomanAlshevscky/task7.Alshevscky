package concurrentExaples.locks.condition.main;

import concurrentExaples.locks.condition.buffer.Buffer;
import concurrentExaples.locks.condition.thread.GetThread;
import concurrentExaples.locks.condition.thread.PutThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();
        GetThread getThread = new GetThread(1, b);
        PutThread putThread = new PutThread(2, b);

        new Thread(getThread).start();
        new Thread(putThread).start();
    }
}
