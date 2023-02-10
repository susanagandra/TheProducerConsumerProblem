import java.util.Deque;
import java.util.Queue;

public class Producer implements Runnable{
    private int numItem;
    Container container;

    public Producer(Container container, int numItem) {
        this.numItem = numItem;
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < numItem; i++) {
            container.addPlate(PlatesMenu.randomPlate().toString());
        }
    }
}
