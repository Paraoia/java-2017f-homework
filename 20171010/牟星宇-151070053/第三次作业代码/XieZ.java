public class XieZ extends Monster {
    private XieZ(){
        super(M_RANK.蝎);
    }

    private static final XieZ Xiez = new XieZ();

    public static XieZ getXiez(){
        return Xiez;
    }
}
