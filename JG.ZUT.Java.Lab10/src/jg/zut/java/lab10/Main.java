package jg.zut.java.lab10;

import jg.zut.java.lab10.consumers.Consumer;
import jg.zut.java.lab10.producers.Producer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static volatile boolean valueSet;
    public static final int QUEUE_SIZE = 21;

        public static void main(String[] args) {
            Queue<Integer> sharedQueue = new PriorityQueue<Integer>();
            Thread producerThread = new Thread(new Producer(sharedQueue));
            Thread consumerThread = new Thread(new Consumer(sharedQueue));
            producerThread.start();
            consumerThread.start();
        }
}
