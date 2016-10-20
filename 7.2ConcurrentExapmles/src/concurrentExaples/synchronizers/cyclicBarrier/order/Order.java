package concurrentExaples.synchronizers.cyclicBarrier.order;

import concurrentExaples.synchronizers.cyclicBarrier.cook.Cook;
import concurrentExaples.synchronizers.cyclicBarrier.element.OrderElement;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by User on 18.10.2016.
 */
public class Order {

    CyclicBarrier barrier;


    public Order(int elementsCount, Cook cook){
        barrier = new CyclicBarrier(elementsCount, cook);
    }

    public void add(OrderElement el) throws BrokenBarrierException, InterruptedException{
        System.out.print(el.getName() + " added to order.\n");
        barrier.await();
    }

}
