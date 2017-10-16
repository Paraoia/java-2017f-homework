public class Calabash {
    private Rank rank;
    private Color color;
    public void Count_off() {
        System.out.print(rank+" ");
    }
    public void Color_off(){
        System.out.print(color+" ");
    }
   /* Calabash(Rank rank,Color color)
    {
        this.rank=rank;
        this.color=color;
    }*/
    Calabash(int n)
    {
        this.rank=Rank.values()[n];
        this.color=Color.values()[n];
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }
    /*public static void main(String[] args){
        Calabash c=new Calabash(Rank.first,Color.RED);
        c.Color_off();
        c.Count_off();
    }*/

}
