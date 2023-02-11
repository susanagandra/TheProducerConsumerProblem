public class Consumer implements Runnable {
    private final Menu menu;
    private int consumedElements;

    public Consumer(Menu menu, int consumedElements) {
        this.menu = menu;
        this.consumedElements = consumedElements;
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
        while (consumedElements > 0) {
            try {
                menu.eat();
                this.consumedElements--;
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}