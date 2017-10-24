public class Scorpion extends Creature {
    public Queue Minions = new Queue();
    public Scorpion(){
        name="蝎子精";
        type=CreatureType.Scorpion;
        Minions.EnQueue(this);
        for(int i=0;i<6;i++)
            Minions.EnQueue(new Minion());
    }
}
