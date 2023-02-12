import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Menu<T> {

    private final Deque<T> container;
    private final int maxSize;
    private final Object FULL_DEQUE = new Object();
    private final Object EMPTY_DEQUE = new Object();

    Menu(int maxSize) {
        this.container = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return container.size() == maxSize;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_DEQUE) {
            FULL_DEQUE.wait();
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_DEQUE) {
            EMPTY_DEQUE.wait();
        }
    }

    public void notifyAllForFull() {
        synchronized (FULL_DEQUE) {
            FULL_DEQUE.notifyAll();
        }
    }

    public void notifyAllForEmpty() {
        synchronized (EMPTY_DEQUE) {
            EMPTY_DEQUE.notifyAll();
        }
    }

    public void add(T plate) {
        synchronized (container) {
            container.add(plate);
            System.out.println(Thread.currentThread().getName().concat(" added ").concat(plate.toString()));
            System.out.println("The menu now has: ".concat(container.toString()));
        }
    }

    public void eat() {
        synchronized (container) {
            if (!container.isEmpty()) {
                String plate = container.remove().toString();
                System.out.println(Thread.currentThread().getName().concat(" ate ").concat(plate));
                if (container.isEmpty()) {
                    System.out.println("The menu is empty");
                } else System.out.println("The menu now has: ".concat(container.toString()));
            }
        }
    }
}