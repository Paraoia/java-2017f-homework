enum CoLor {
    red("红色"), orange("橙色"), yellow("黄色"), green("绿色"), indigo("青色"), blue("蓝色"), purple("紫色");

    private String name;

    private CoLor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

enum RANK {
    one("老大"), two("老二"), three("老三"), four("老四"), five("老五"), six("老六"), seven("老七");

    private String name;

    private RANK(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Calabash
{
    private int rank;
    private CoLor crank;
    private RANK name;

    public int getRank() {
        return rank;
    }

    public CoLor getCrank() {
        return crank;
    }

    public RANK getName() {
        return name;
    }

    Calabash(int r, CoLor c, RANK n)
    {
        rank=r;
        crank=c;
        name=n;
    }

    Calabash(int n)
    {
        rank=n+1;
        this.crank=CoLor.values()[n];
        this.name=RANK.values()[n];
    }
    void reportrank()
    {
        System.out.println(name.getName());
    }

    void reportcrank()
    {
        System.out.println(crank.getName());
    }

}
