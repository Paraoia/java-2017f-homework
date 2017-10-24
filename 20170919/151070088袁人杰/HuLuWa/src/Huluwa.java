public class Huluwa implements Creature,Comparable{
    private SENIORITY seniority;
    private Position position;//葫芦娃的位置
    private COLOUR colour;//葫芦娃的颜色

    public Huluwa(){

    }


    public Huluwa(COLOUR colour,SENIORITY seniority){
        this.colour = colour;
        this.seniority = seniority;
    }

    public void setColor(COLOUR colour) {
        this.colour = colour;
    }

    public COLOUR getColour() {
        return colour;
    }

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
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        return "老" + this.seniority.toString() + "(" + this.colour + ")@Position" + this.position.getX() + ", ";
    }

    @Override
    public boolean biggerThan(Comparable bro) {

        if (bro instanceof Huluwa)
            return this.getSeniority().toNumber() > ((Huluwa) bro).getSeniority().toNumber();
        else
            return false;
    }

    enum COLOUR {
        RED(1),ORANGE(2),YELLOW(3),GREEN(4),BLUE(5),INDIGO(6),VIOLET(7);

        private int cNum=0;

        private COLOUR(int _cNum) {
            this.cNum=_cNum;
        }

        public int toNumber() {
            return this.cNum;
        }

    }

    enum SENIORITY {
        一(1),二(2),三(3),四(4),五(5),六(6),七(7);

        private int sNum=0;

        private SENIORITY(int _sNum) {
            this.sNum=_sNum;
        }

        public int toNumber() {
            return this.sNum;
        }
    }

}
