package concurrentExaples.synchronizers.countDownLatch.project;


import concurrentExaples.synchronizers.countDownLatch.element.ProjectElement;

import java.util.concurrent.CountDownLatch;

/**
 * Created by User on 18.10.2016.
 */
public class SomeProject {

    private CountDownLatch projectElements;
    private String name;

    public SomeProject(String name, int elementsCount){
        this.name = name;
        projectElements = new CountDownLatch(elementsCount);
    }

    public void add(ProjectElement el) throws InterruptedException{
        projectElements.countDown();
        System.out.print(el.getName() + " was added to"+ name +".\n");
        projectElements.await();
    }


}
