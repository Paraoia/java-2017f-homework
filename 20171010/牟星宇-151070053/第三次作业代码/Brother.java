public class Brother implements Creature, Comparable{

    private COLOR color;
    private RANK rank;
    private Position position;

    public Brother(COLOR color, RANK rank){
        this.color = color;
        this.rank = rank;
        this.position = null;
    }

    public COLOR getColor(){
        return color;
    }

    public RANK getRank(){
        return rank;
    }

    @Override
    public Position getPosition(){
        return this.position;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
        //position.setHolder(this);
    }

    @Override
    public void cleanPosition(){
        this.position = null;
    }

    @Override
    public String toString(){
        return this.rank.toString(); //+ "(" +this.color.toString() + ")@(" + this.position.getX() + "," + this.position.getY() + ");";
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

    @Override
    public boolean rank_biggerThan(Comparable another){
        if(another instanceof Brother)
            return this.getRank().ordinal() > ((Brother) another).getRank().ordinal();
        else if(another instanceof Monster)
            return true;
        else
            return false;
    }

    /*
    @Override
    public boolean color_biggerThan(Comparable another){
        if(another instanceof Brother)
            return this.getColor().ordinal() > ((Brother) another).getColor().ordinal();
        else
            return false;
    }
    */


}

enum COLOR{
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum RANK{
    一, 二, 三, 四, 五, 六, 七
}
