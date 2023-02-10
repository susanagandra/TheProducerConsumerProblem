import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Container<T> {
    private int plateLimit;
    Deque<T> menu;

    public Container(int plateLimit) {
        this.plateLimit = plateLimit;
        this.menu = new ConcurrentLinkedDeque();
    }

    void addPlate(T plate) {

        while (menu.size() >= plateLimit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (menu.size() < plateLimit) {
            menu.add(plate);
        }
            notifyAll();
    }

    void removePlate(int numPlates) {

        while (menu.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!menu.isEmpty()) {
        for (int i = 0; i < numPlates; i++) {
                menu.remove();
        }
            notifyAll();
        }
    }
}
