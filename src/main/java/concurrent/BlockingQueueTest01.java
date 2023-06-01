package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * bounded: possui limite de valores.
 * se tentar colocar acima desse limite, a thread fica bloqueada até poder colocar um novo valor.
 **/
public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Primeira pessoa");

        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());

        new Thread(new RemoveFromQueue(bq)).start();

        System.out.println("main trying to add another value");
        bq.put("Segunda pessoa");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
    }

    static class RemoveFromQueue implements Runnable {
        private final BlockingQueue<String> queue;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.queue = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
