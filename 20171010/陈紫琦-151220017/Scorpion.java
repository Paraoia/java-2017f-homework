
public class Scorpion extends Creature //蝎子精类
{
    Scorpion()
    {
        super();this.species = Species.SCORPION;
    }
    public void report()
    {
        System.out.print("蝎子精");
    }
}
class Minion extends Creature //小喽啰类
{
    int index;
    Minion(int index)
    {
        super();
        this.index = index;
        this.species = Species.MINION;
    }
    public void report()
    {
        System.out.print("喽啰"+ index );
    }
}


