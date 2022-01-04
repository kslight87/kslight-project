package hello.core.datastructure;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.offer(1);
        System.out.println("offer" + queue);
        queue.offer(2);
        System.out.println("offer" + queue);
        queue.offer(3);
        System.out.println("offer" + queue);
        queue.offer(4);
        System.out.println("offer" + queue);
        queue.offer(5);

        queue.poll();
        System.out.println("poll" + queue);
        queue.poll();
        System.out.println("poll" + queue);
        queue.poll();
        System.out.println("poll" + queue);
        queue.poll();
        System.out.println("poll" + queue);
        queue.poll();
    }
}
