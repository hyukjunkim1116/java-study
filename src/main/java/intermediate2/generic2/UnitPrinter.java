package intermediate2.generic2;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        System.out.println(shuttle.info);
    }
    public static void printV2(Shuttle<? extends BioUnit> shuttle) {
        System.out.println(shuttle.info);
    }
}
