package concurrentExaples.synchronizers.exchanger.student;

import java.util.concurrent.Exchanger;

/**
 * Created by User on 18.10.2016.
 */
public class Student implements Runnable {

    private static final Exchanger<String> exchanger = new Exchanger<>();
    private String myAnswers;
    private String myFriendAnswers;
    private int id;

    public Student(int id){
        this.id = id;
        System.out.print("Student "+ id+ " started exam.\n");
    }

    private void exchangeAnswers() throws InterruptedException{
        myFriendAnswers = exchanger.exchange(myAnswers);
        System.out.print("Student "+ id+ " exchanged answers.\n");
    }

    public void answerTheQuestions() throws InterruptedException{
        Thread.sleep(2000);
        myAnswers = "A, C, A, A, D, E, B";
        System.out.print("Student "+ id + " answer the questions.\n");
    }

    @Override
    public void run() {
        try{
            answerTheQuestions();
            exchangeAnswers();
            System.out.print("Student "+ id+ " passed the exam.\n");
        } catch (InterruptedException e){
            System.out.print("Teacher expelled student from the audience");
        }
    }

}
