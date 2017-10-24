enum COLOR {
    red,orange,yellow,green,cyan,blue,purple
}
enum RANK {
    one,two,three,four,five,six,seven
}
public class Huluwa extends Creature {
private COLOR COLOR;
    private RANK RANK;

    public COLOR getColor() {
        return COLOR;
    }

    public RANK getSeniority() {
        return RANK;
    }

    Huluwa(COLOR COLOR, RANK rank) {
        this.COLOR = COLOR;
        this.RANK = rank;
        type=CreatureType.Huluwa;
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

}


