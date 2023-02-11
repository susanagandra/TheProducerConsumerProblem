import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Menu<T> {
    BlockingQueue<T> menu;

    public Menu(int maxSize) {
        this.menu = new LinkedBlockingDeque<>(maxSize);
    }

    public void addPlate(T plate) throws InterruptedException {
        menu.put(plate);
        System.out.println(Thread.currentThread().getName().concat(" added ").concat(plate.toString()) + "\n" +
                "The menu now has: ".concat(menu.toString()));
    }

    public void eat() throws InterruptedException {
        String plate = menu.take().toString();
        System.out.println(Thread.currentThread().getName().concat(" ate ").concat(plate) + "\n" +
                "The menu now has: ".concat(menu.toString()));
    }
}