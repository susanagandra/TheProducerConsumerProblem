public class Consumer implements Runnable {
    private int numItem;
    Container container;

    public Consumer(Container container, int numItem) {
        this.numItem = numItem;
        this.container = container;
    }

    @Override
    public void run() {
        container.removePlate(numItem);
    }
}
