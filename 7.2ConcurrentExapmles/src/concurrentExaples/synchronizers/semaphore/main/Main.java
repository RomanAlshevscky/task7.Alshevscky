package concurrentExaples.synchronizers.semaphore.main;

import concurrentExaples.synchronizers.semaphore.car.Car;
import concurrentExaples.synchronizers.semaphore.parking.Parking;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Parking mainParking = new Parking(5);

        Car[] cars = new Car[8];
        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car(i, mainParking);
            new Thread(cars[i]).start();
        }

        for(int i = 0; i < cars.length; i++){
            Thread.sleep(1000);
            cars[i].crash();
        }

    }
}
