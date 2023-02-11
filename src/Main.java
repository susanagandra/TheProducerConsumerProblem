public class Main {
    public static void main(String[] args) {

        Menu<String> menu = new Menu<>(10);

        Producer p1 = new Producer(menu, 20);
        Thread t1 = new Thread(p1);
        t1.setName("Chef Kiko");

        Producer p2 = new Producer(menu, 20);
        Thread t2 = new Thread(p2);
        t2.setName("Chef Justa Nobre");

        Consumer c1 = new Consumer(menu, 10);
        Thread t3 = new Thread(c1);
        t3.setName("Susana");

        Consumer c2 = new Consumer(menu, 15);
        Thread t4 = new Thread(c2);
        t4.setName("Rafael");

        Consumer c3 = new Consumer(menu, 15);
        Thread t5 = new Thread(c3);
        t5.setName("Nuno");

        t3.start();
        t4.start();
        t5.start();

        t1.start();
        t2.start();

    }
}