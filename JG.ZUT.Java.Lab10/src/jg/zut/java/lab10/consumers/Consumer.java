package jg.zut.java.lab10.consumers;

import jg.zut.java.lab10.Main;
import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                getPackage();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void getPackage() throws InterruptedException {
        synchronized (queue)
        {
            while (!Main.valueSet)
            {
                queue.wait();
            }
            MakeConsumerABitSlower();
            Integer value = queue.remove();
            System.out.println("Getting package <" + value + ">" + ", count<" + queue.stream().count() +">.");
            if (queue.size() == 0) {
                Main.valueSet = false;
            }
            queue.notifyAll();
        }
    }

    private void MakeConsumerABitSlower() throws InterruptedException {
        Thread.sleep(300);
    }
}

