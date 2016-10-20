package concurrentExaples.synchronizers.semaphore.parking;

import java.util.concurrent.Semaphore;

/**
 * Created by User on 18.10.2016.
 */
public class Parking {

    Semaphore parking;

    public Parking(int placesCount){
        this.parking = new Semaphore(placesCount, true);
    }

    public void takePlace() throws InterruptedException{
        parking.acquire();
    }

    public void leavePlace(){
        parking.release();
    }
}
