import java.util.Random;

public enum PlatesMenu {
    RICE,
    TUNA,
    PIZZA,
    NODDLES,
    FILET,
    CUCUS,
    SUSHI,
    PUDIM,
    BOLO,
    PASTA;

    public static PlatesMenu randomPlate()  {
        PlatesMenu[] plates = values();
        return plates[(new Random()).nextInt(plates.length)];
    }

}
