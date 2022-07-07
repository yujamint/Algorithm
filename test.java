import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); // int형 queue 선언

        q.offer(3);
        q.offer(5);
//        q.offer(1);
//        q.offer(4);
        System.out.println(q.poll());
        System.out.println(q.remove());
    }
}
