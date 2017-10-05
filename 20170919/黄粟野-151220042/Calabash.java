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

    //对类中三个private变量的get和set函数
    public int getRank() {
        return rank;
    }

    public CoLor getCrank() {
        return crank;
    }

    public RANK getName() { return name; }

    public void setRank(int rank) { this.rank = rank; }

    public void setCrank(CoLor crank) { this.crank = crank; }

    public void setName(RANK name) { this.name = name; }

    //因为后续需要所定义的两个构造函数
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


    //在排序过程中交换位置时可以报告自己变换情况
    void reportchangingposition(int pos1,int pos2)
    {
        System.out.println(getName().getName()+":"+pos1+"->"+pos2);
    }

    //报告自己的颜色
    void reportrank()
    {
        System.out.print(getCrank().getName()+" ");
    }

    //报告自己在七兄弟中的位置
    void reportpos()
    {
        System.out.print(getName().getName()+" ");
    }

    //跳到七兄弟中的另一个位置，同时把目标位置上的兄弟放到自己位置上
    void hop(Calabash brothers[],int target2)
    {
        Calabash temp = new Calabash(getRank(),getCrank(),getName());
        setRank(brothers[target2].getRank());
        setName(brothers[target2].getName());
        setCrank(brothers[target2].getCrank());

        brothers[target2] = temp;
    }
}
