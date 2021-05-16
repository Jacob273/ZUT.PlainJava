package jg.zut.java.lab10.producers;

import jg.zut.java.lab10.Main;
import java.util.Queue;
import static jg.zut.java.lab10.Main.QUEUE_SIZE;

public class Producer implements Runnable {

    private static volatile int packageId;
    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try
            {
                insertPackage();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void insertPackage() throws InterruptedException {
        synchronized (queue)
        {
            while (Main.valueSet)
            {
                queue.wait();
            }
            MakeProducerABitSlower();
            queue.add(Producer.packageId);
            System.out.println("Producing package <" + Producer.packageId++ +">" + ", count<" + queue.stream().count() +">.");
            if (queue.size() == QUEUE_SIZE) {
                Main.valueSet = true;
            }
            queue.notifyAll();
        }
    }

    private void MakeProducerABitSlower() throws InterruptedException {
        Thread.sleep(300);
    }
}
