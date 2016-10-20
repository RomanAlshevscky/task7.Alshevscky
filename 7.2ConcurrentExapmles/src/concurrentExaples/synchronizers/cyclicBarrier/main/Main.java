package concurrentExaples.synchronizers.cyclicBarrier.main;

import concurrentExaples.synchronizers.cyclicBarrier.cook.Cook;
import concurrentExaples.synchronizers.cyclicBarrier.element.OrderElement;
import concurrentExaples.synchronizers.cyclicBarrier.order.Order;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int elementsCount = 5;
        Cook mainCook = new Cook();
        Order order = new Order(elementsCount, mainCook);

        OrderElement[] orderElements = new OrderElement[elementsCount];

        orderElements[0] = new OrderElement("steak", 4000, order);
        orderElements[1] = new OrderElement("salad", 2000, order);
        orderElements[2] = new OrderElement("french bean", 3200, order);
        orderElements[3] = new OrderElement("bread", 1200, order);
        orderElements[4] = new OrderElement("wine", 2000, order);

        for(int i = 0; i < elementsCount; i++){
            new Thread(orderElements[i]).start();
        }

        Thread.sleep(10000);

        mainCook.dismiss();

        for(int i = 0; i < elementsCount; i++){
            orderElements[i].emptyTheStock();
        }

    }
}
