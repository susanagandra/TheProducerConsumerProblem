public class Producer implements Runnable {
    private final Menu menu;
    private volatile boolean available;
    private int elementsToProduce;

    public Producer(Menu menu, int elementsToProduce) {
        this.menu = menu;
        this.elementsToProduce = elementsToProduce;
        available = true;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        while (available && elementsToProduce > 0) {
            String plate = PlatesMenu.randomPlate();
            ThreadUtil.sleep(1000);
            while (menu.isFull()) {
                try {
                    menu.waitOnFull();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (!available) {
                break;
            }
            menu.add(plate);
            elementsToProduce--;
            menu.notifyAllForEmpty();
        }
        System.out.println(Thread.currentThread().getName().concat(" has stopped working."));
    }
}