/**
 * Created by Yuyang Wei on 2017/10/16.
 */
public class Huluwa implements Creature, Comparable{
    private COLOR color;
    private SENIORITY seniority;
    private Position position;

    public COLOR getColor() {
        return color;
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

    Huluwa(COLOR color, SENIORITY seiority) {
        this.color = color;
        this.seniority = seiority;
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString(){
        return this.seniority.toString() + "(" + this.color.toString() + ")@(" + this.position.getX() + ","+this.position.getY()+");";
    }

    @Override
    public boolean biggerThan(Comparable brother){

        if (brother instanceof  Huluwa)//result = object instanceof class
            // 如果 object 是 class 的一个实例，则 instanceof 运算符返回 true。
            // 如果 object 不是指定类的一个实例，或者 object 是 null，则返回 false。
            return this.getSeniority().ordinal()> ((Huluwa) brother).getSeniority().ordinal();
        else
            return false;
    }

}

enum COLOR{
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}