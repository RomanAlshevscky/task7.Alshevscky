package concurrentExaples.locks.lock.thread;


import concurrentExaples.locks.lock.buffer.Buffer;

public class GetThread implements Runnable {

    private int id;
    private Buffer buffer;

    public GetThread(int id, Buffer b){
        this.id = id;
        buffer = b;
    }

    @Override
    public void run() {
        try {
            while (!buffer.isEmpty()) {
                Thread.sleep(80);
                buffer.get();
                System.out.print("Поток " + id + " извлек объект\n");
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
