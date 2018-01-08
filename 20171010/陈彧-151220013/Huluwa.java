public class Huluwa implements Creature, Comparable {
    private COLOR color;
    private SENIORITY seniority;
    private Position position;

    public Huluwa(COLOR color, SENIORITY seniority) {
        this.color = color;
        this.seniority = seniority;
    }

    public COLOR getColor() {
        return color;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }

    @Override
    public boolean biggerThan(Comparable brother) {
        if(brother instanceof Huluwa)
            return (this.getSeniority().ordinal() > ((Huluwa) brother).getSeniority().ordinal());
        return false;
    }

    @Override
    public void report() {
            System.out.print(seniority + " ");
//        System.out.print(this.toString());
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        if(position != null) {
            position.setHolder(this);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.seniority.toString() + "(" + this.color.toString() + ")@" + this.position.getX() + ";";
    }
}

enum COLOR {
    赤,橙,黄,绿,青,蓝,紫
}

enum SENIORITY{
    一,二,三,四,五,六,七
}