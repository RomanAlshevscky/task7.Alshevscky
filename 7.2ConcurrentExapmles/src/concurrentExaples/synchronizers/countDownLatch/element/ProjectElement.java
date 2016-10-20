package concurrentExaples.synchronizers.countDownLatch.element;

import concurrentExaples.synchronizers.countDownLatch.project.SomeProject;

/**
 * Created by User on 18.10.2016.
 */
public class ProjectElement implements Runnable {

    private String name;
    private int developingTime;
    private SomeProject someProject;

    /**
     * @param elementName
     * @param developingTime
     * @param sp Shared resource
     */
    public ProjectElement(String elementName, int developingTime, SomeProject sp){
        name = elementName;
        this.developingTime = developingTime;
        someProject = sp;
    }

    public String getName(){ return name; }

    @Override
    public void run() {
        try {
            Thread.sleep(developingTime);
            someProject.add(this);
            System.out.print("\n" + name + " was relesed with the project.\n");
        } catch(InterruptedException e){
            System.out.print("Customer refuse " +  name+"\n");
        }
    }


}
