package concurrentExaples.synchronizers.semaphore.car;

import concurrentExaples.synchronizers.semaphore.parking.Parking;

/**
 * Created by User on 18.10.2016.
 */
public class Car implements Runnable {

    private boolean isBroken;
    private int carId;
    private Parking localParking;

    /**
     * @param id Thread id;
     * @param p Shared object
     */
    public Car(int id, Parking p){
        isBroken = false;
        carId = id;
        localParking = p;
    }

    /**
     * Stop thread
     */
    public void crash(){
        isBroken = true;
    }

    @Override
    public void run() {
        try {
            while (!isBroken) {
                park();
                stand();
                leaveTheParking();
                inRoad();
            }
        } catch(InterruptedException e){
            System.out.print("SomeProject \"" + carId + "\" was crashed.\n");
        }
    }

    private void park() throws InterruptedException{
        System.out.print("SomeProject \"" + carId + "\" try to take place.\n");
        localParking.takePlace();
        System.out.print("SomeProject \"" + carId + "\" parked.\n");
    }

    private void stand() throws InterruptedException {
        Thread.sleep(1000);
    }

    private void leaveTheParking(){
        System.out.print("SomeProject \"" + carId + "\" leaved parking.\n");
        localParking.leavePlace();
    }

    private void inRoad() throws InterruptedException {
        Thread.sleep(1000);
    }
}
