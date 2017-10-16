enum Species //物种
{
    HULUWA, OLDMAN, SNAKE, SCORPION, MINION;
}
abstract public class Creature //抽象类：生物
{
    public Species species; //物种
    protected Position position; //位置
    abstract public void report(); //报名字
    Creature()
    {
        position = null;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public void setPosition(Position position) //设置位置
    {
        if(position.ifEmpty())
        {
            leavePosition();
            position.setHolder(this);
            this.position = position;
        }
        else assert(false);
    }
    public void leavePosition() //离开位置
    {
        if(this.position != null)
        {
            (this.position).out();
            this.position = null;
        }

    }

}
class Oldman extends Creature //生物：老爷爷
{
    Oldman()
    {
        super();
        this.species = Species.OLDMAN;
    }
    public void report()
    {
        System.out.print("老爷爷");
    }
}

class Snake extends Creature //生物：蛇精
{
    Snake()
    {
        super();
        this.species = Species.SNAKE;
    }
    public void report()
    {
        System.out.print("蛇精");
    }
}
