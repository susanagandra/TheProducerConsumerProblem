public class Producer implements Runnable {
    private final Menu menu;
    private int elementsToProduce;

    public Producer(Menu menu, int elementsToProduce) {
        this.menu = menu;
        this.elementsToProduce = elementsToProduce;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        while (elementsToProduce > 0) {
            String plate = PlatesMenu.randomPlate();
            try {
                menu.addPlate(plate);
                elementsToProduce--;
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}