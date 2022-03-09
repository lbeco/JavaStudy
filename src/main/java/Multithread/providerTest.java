package Multithread;

import java.util.Deque;
import java.util.LinkedList;

public class providerTest {
    public static void main(String[] args) {
        Container container = new Container();
        Provider provider= new Provider(container);
        Provider provider2= new Provider(container);
        Consumer consumer = new Consumer(container);
        provider.start();
        consumer.start();
        provider2.start();

    }
}

class Provider extends Thread {
    private Container container;
    private int chickenId;

    public Provider(Container container) {
        this.container = container;
        chickenId = 0;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(chickenId));
            System.out.println("product " + chickenId);
            chickenId++;
        }

    }


}

class Consumer extends Thread {
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            Chicken chicken = container.pop();
            System.out.println("consume " + chicken.id);
        }

    }
}

class Container {
    Deque<Chicken> chickenList = new LinkedList<>();

    public synchronized void push(Chicken chicken) {
        if (chickenList.size() == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        chickenList.push(chicken);
        this.notify();

    }

    public synchronized Chicken pop() {
        if (chickenList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        Chicken chicken = chickenList.pop();
        this.notifyAll();
        return chicken;
    }

}

class Chicken {
    public Integer id;

    public Chicken(int id) {
        this.id = id;
    }
}

