import javafx.geometry.Pos;

public class Position
{
    Creature creature;
    //int x,y;

    Position()
    {
        creature=new Creature();
    }

    void SetCreature(Creature c)
    {
        creature=c;
    }
    Creature GetCreature()
    {
        return creature;
    }
    void show()
    {
        creature.show();
    }

}
