package intermediate2.generic2;

public class UnitUtil{
    public static <E extends BioUnit> E maxHp(E unit1, E unit2) {
        int hp1 = unit1.getHp();
        int hp2 = unit2.getHp();
        return hp1 > hp2 ? unit1 : unit2;
    }
}
