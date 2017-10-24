public class BadCamp extends Camp {
    BadCamp()
    {
        this.sum=7;
        this.creature=new Creature[7];
        creature[0]=new Scorption();
        for(int i=1;i<7;i++)
        {
            creature[i]=new Monstor();
        }
    }
}
