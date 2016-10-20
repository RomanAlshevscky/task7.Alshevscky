package concurrentExaples.locks.condition.buffer;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private Stack<Object> buffer = new Stack<>();
    private int maxElementsCount = 4;
    private Lock mainLock = new ReentrantLock();
    private Condition notEmptyBuffer = mainLock.newCondition();
    private Condition notFullBuffer = mainLock.newCondition();

    public void put(Object o){
        mainLock.lock();
        try {
            while (buffer.size() == maxElementsCount) {
                System.out.print("Буффер полон\n");
                notFullBuffer.await();
            }
            buffer.push(o);
            notEmptyBuffer.signal();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        } finally {
            mainLock.unlock();
        }
    }

    public Object get(){
        mainLock.lock();
        Object result = null;
        try{
            while(buffer.isEmpty()){
                System.out.print("Буффер пуст\n");
                notEmptyBuffer.await();
            }
            result = buffer.pop();
            notFullBuffer.signal();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            mainLock.unlock();
        }
        return result;
    }

}
