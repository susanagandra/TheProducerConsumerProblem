import java.util.Random;

public enum PlatesMenu {
    P1("Arroz com atum"),
    P2("Bife à portuguesa"),
    P3("Pizza Napolitana"),
    P4("Noddles Cigala"),
    P5("Filet Mignon"),
    P6("Cheeseburguer"),
    P7("36 peças de sushi"),
    P8("Arroz de cabidela"),
    P9("Bacalhau à brás"),
    P10("Massa à Carbonara");

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