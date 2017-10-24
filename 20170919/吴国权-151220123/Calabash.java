public class Calabash {
    private String name;
    private String color;
    private int position;
    private int rank;

    Calabash(String name,String color,int position,int rank)
    {
        this.name=name;
        this.color=color;
        this.position=position;
        this.rank=rank;
    }

    int Getrank()
    {
        return rank;
    }

    void MyName() { System.out.print(name+"  "); }

    void MyColor()
    {
        System.out.print(color+"  ");
    }

    void ChangePosition(int location)
    {
        System.out.println(name+":"+position+"->"+location);
        this.position=location;
    }

}
