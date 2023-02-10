import java.util.Random;

public enum PlatesMenu {
    TUNA("Arroz com atum"),
    STEAK("Bife à portuguesa"),
    PIZZA("Pizza Napolitana"),
    NODDLES("Noddles Cigala"),
    FILET("Filet Mignon"),
    HAMBURGER("Cheeseburguer"),
    SUSHI("36 peças de sushi"),
    RICE("Arroz de cabidela"),
    POTATOES("Bacalhau à brás"),
    PASTA("Massa à Carbonara");

    private final String plateName;

    PlatesMenu(String plateName) {
        this.plateName = plateName;
    }

    public String getPlateName() {
        return plateName;
    }

    public static String randomPlate() {
        PlatesMenu[] plates = values();
        return plates[(new Random()).nextInt(plates.length)].getPlateName();
    }
}