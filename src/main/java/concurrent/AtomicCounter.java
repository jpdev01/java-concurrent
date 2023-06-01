package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Contagem de forma atômica.
 * técnica compare and swap. Utilizada para design de algoritmos que trabalham em concorrência.
 * compara e troca os valores baseado se o valor na variável é correto.
 */
class AtomicCounter {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();

    void increment() {
        count++;
        atomicInteger.incrementAndGet();
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}

class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Contador padrão: " + counter.getCount());
        System.out.println("Contador atômico: " + counter.getAtomicInteger());
    }
}