public class Huluwa implements Creature, Comparable{

    private COLOR color;
    private RANK rank;
    private Position position;

    public COLOR getColor() {
        return color;
    }

    public RANK getRank() {
        return rank;
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

    Huluwa(COLOR color, RANK rank) {
        this.color = color;
        this.rank = rank;
    }

    @Override
    public void report() {
        System.out.print(String.format("%-12s",this.toString()));
    }

    @Override
    public String toString(){
        return "@" + this.position.getX()+","+this.position.getY()+this.rank.toString()+"娃" + "(" + this.color.toString() + ")" + ";";
    }

    @Override
    public boolean biggerThan(Comparable brother){

        if (brother instanceof  Huluwa)
            return this.getRank().ordinal()> ((Huluwa) brother).getRank() .ordinal();
        else
            return false;
    }

}

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum RANK {
    一, 二, 三, 四, 五, 六, 七
}