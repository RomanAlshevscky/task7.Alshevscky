package concurrentExaples.locks.condition.thread;

import concurrentExaples.locks.condition.buffer.Buffer;

public class PutThread implements Runnable {

    private int id;
    private int iterationsCount = 5;
    private Buffer buffer;

    public PutThread(int id, Buffer b){
        this.id = id;
        buffer = b;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= iterationsCount; i++) {
                Thread.sleep(90);
                buffer.put(new Object());
                System.out.print("Поток " + id+" положил объект\n");
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
