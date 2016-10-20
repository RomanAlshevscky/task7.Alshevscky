package concurrentExaples.synchronizers.cyclicBarrier.element;

import concurrentExaples.synchronizers.cyclicBarrier.order.Order;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by User on 18.10.2016.
 */
public class OrderElement implements Runnable {

    private String name;
    private int cookingTime;
    private Order order;
    private boolean isInStock;

    /**
     * @param elementName
     * @param cookingTime
     * @param so Shared resource
     */
    public OrderElement(String elementName, int cookingTime, Order so){
        name = elementName;
        this.cookingTime = cookingTime;
        order = so;
        isInStock = true;
    }

    public void emptyTheStock(){
        isInStock = false;
    }

    public String getName(){ return name; }

    @Override
    public void run() {
        while(isInStock) {
            try {
                Thread.sleep(cookingTime);
                order.add(this);
                System.out.print(name + " was tasty.\n");
            } catch (InterruptedException e) {
                System.out.print("Customer refuse " + name + "\n");
            } catch (BrokenBarrierException bbe) {
                System.out.print("Customer refuse order");
            }
        }

    }


}
