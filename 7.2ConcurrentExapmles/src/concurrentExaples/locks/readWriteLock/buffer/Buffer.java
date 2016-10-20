package concurrentExaples.locks.readWriteLock.buffer;

import java.util.Stack;
import java.util.concurrent.locks.*;

public class Buffer {

    Stack<Object> buffer = new Stack<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();


    public void put(Object o){
        writeLock.lock();
        try {
            buffer.push(o);
        } finally {
            writeLock.unlock();
        }
    }

    public Object read(){
        readLock.lock();
        Object result = null;
        try{
            if(!buffer.isEmpty()){
                result = buffer.peek();
            }
        } finally {
            readLock.unlock();
        }
        return result;
    }

}
