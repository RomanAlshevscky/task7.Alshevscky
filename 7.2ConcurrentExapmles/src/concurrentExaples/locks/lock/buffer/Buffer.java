package concurrentExaples.locks.lock.buffer;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private Stack<Object> buffer = new Stack<>();
    private int maxElementsCount = 15;
    private Lock mainLock = new ReentrantLock();

    public Buffer(){
        for(int i = 0; i<maxElementsCount; i++){
            buffer.push(new Object());
        }
    }

    public boolean isEmpty(){
        return buffer.isEmpty();
    }

    public Object get(){
        mainLock.lock();
        Object result = null;
        try{
            if(!buffer.isEmpty())
                result = buffer.pop();
        } finally {
            mainLock.unlock();
        }
        return result;
    }

}
