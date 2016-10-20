package concurrentExaples.locks.readWriteLock.thread;

import concurrentExaples.locks.readWriteLock.buffer.Buffer;

public class GetThread implements Runnable {

    private int id;
    private int iterationsCount = 5;
    private Buffer buffer;

    public GetThread(int id, Buffer b){
        this.id = id;
        buffer = b;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= iterationsCount; i++) {
                Thread.sleep(80);
                buffer.read();
                System.out.print("Поток " + id+" прочитал объект\n");
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
