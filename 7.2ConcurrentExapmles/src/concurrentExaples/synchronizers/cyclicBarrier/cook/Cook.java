package concurrentExaples.synchronizers.cyclicBarrier.cook;

/**
 * Created by User on 18.10.2016.
 */
public class Cook implements Runnable {

    private boolean isAtWork = true;
    //Stop all threads in cycle
    public void dismiss(){
        isAtWork = false;
    }

    public void giveOrder(){
        System.out.print("\nThe order given to a customer.\n\n");
    }

    @Override
    public void run() {
        if(isAtWork)
            giveOrder();
        else
            System.out.print("\nLast order\n");
    }
}
