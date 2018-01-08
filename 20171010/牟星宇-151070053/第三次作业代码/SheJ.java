public class SheJ extends Monster {
    private SheJ(){
        super(M_RANK.蛇);
    }

    private static final SheJ Shej = new SheJ();

    public static SheJ getShej(){
        return Shej;
    }
}
