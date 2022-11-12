import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class InterviewPanel {
    public static void main(String[] args) throws InterruptedException {
        details ( );
    }
    private static void details() throws InterruptedException {
        Queue<String> candidate = new LinkedList<> ( );
        candidate.add ("Rose");
        candidate.add ("Lavender");
        candidate.add ("Sunflower");
        candidate.add ("Jasmine");
        candidate.add ("Violet Flower");
        candidate.add ("Butterfly");
        candidate.add ("Peacock");
        candidate.add ("Parrot");
        candidate.add ("Purple Flower");
        System.out.println ("Candidates enrolled for interview");
        System.out.println ("_______________________");
        int length = candidate.size ( );
        for (String s : candidate) {
            System.out.println (s);
        }
        System.out.println ("_______________________");
        waitingRoom (candidate, length);
    }
    private static void waitingRoom(Queue<String> candidate, int length) throws InterruptedException {
        Queue<String> waitingRoom = new LinkedList<> ( );
        for (int i = 0; i < 5; i++) {
            waitingRoom.add (candidate.poll ( ));
        }
        System.out.println ("Candidates in Waiting Room");
        System.out.println ("--------------------------------");
        //System.out.println(candidateDetails);
        for (String s : waitingRoom) {
            System.out.println (s);
        }
        callForInterview (candidate, waitingRoom, length);
    }

    private static void callForInterview(Queue<String> candidate, Queue<String> waitingRoom, int length) throws InterruptedException {
        System.out.println ("_____________________________");
        while (length != 0) {
            int index = 1;
            System.out.println ("Candidates Called For Interview:" + " " + waitingRoom.poll ( ));
            System.out.println ("--------------------------------");
            if (!candidate.isEmpty ( )) waitingRoom.add (candidate.poll ( ));
            Iterator iterator = waitingRoom.iterator ( );
            if (waitingRoom.isEmpty ( )) System.out.println ("Interview finished");
            else {
                System.out.println ("People in waiting room");
                System.out.println ("______________________");
            }
            while (iterator.hasNext ( )) System.out.println (index++ + "." + iterator.next ( ));
            length--;
        }
    }
}


