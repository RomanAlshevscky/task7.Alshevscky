package concurrentExaples.synchronizers.countDownLatch.main;

import concurrentExaples.synchronizers.countDownLatch.element.ProjectElement;
import concurrentExaples.synchronizers.countDownLatch.project.SomeProject;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int elementsCount = 5;
        SomeProject project = new SomeProject("Super Project", elementsCount);

        ProjectElement[] projectElements = new ProjectElement[elementsCount];

        projectElements[0] = new ProjectElement("main module", 3000, project);
        projectElements[1] = new ProjectElement("super main module", 4000, project);
        projectElements[2] = new ProjectElement("bugs", 3200, project);
        projectElements[3] = new ProjectElement("service", 1200, project);
        projectElements[4] = new ProjectElement("interface", 2000, project);

        for(int i = 0; i < elementsCount; i++){
            new Thread(projectElements[i]).start();
        }

    }
}
