public class Consumer implements Runnable {
    private final Menu menu;
    private volatile boolean available;
    private int consumedElements;

    public Consumer(Menu menu, int consumedElements) {
        this.menu = menu;
        this.consumedElements = consumedElements;
        available = true;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        while (available && consumedElements > 0) {
            if (menu.isEmpty()) {
                try {
                    menu.waitOnEmpty();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (!available) {
                break;
            }
            menu.notifyAllForFull();
            menu.eat();
            ThreadUtil.sleep(1000);
            consumedElements--;
        }
        System.out.println(Thread.currentThread().getName().concat(" doesn't want to order anything else."));
    }
}