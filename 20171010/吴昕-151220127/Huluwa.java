public class Huluwa implements Creature {

    public SENIORITY getSeniority() {
        return seniority;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public String toString() {
        return this.seniority.toString();
    }

    Huluwa(SENIORITY seniority) {
        this.seniority = seniority;
    }

	private SENIORITY seniority;
	private Position position;

}

enum SENIORITY {
	一, 二, 三, 四, 五, 六, 七
}
