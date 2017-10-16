enum HuluAttribute//葫芦娃属性
{
    RED("老大","红色",1), ORANGE("老二", "橙色",2), YELLOW("老三", "黄色",3), GREEN("老四","绿色",4),
    CYAN("老五","青色",5), BLUE("老六", "蓝色", 6), PURPLE("老七", "紫色", 7);
    private String NoName; //老X
    private String ColorName; //颜色
    private int index; //序号
    private HuluAttribute(String NoName, String ColorName, int index) //构造函数
    {
        this.NoName = NoName;
        this.ColorName = ColorName;
        this.index = index;
    }
    public  String getNoName()
    {
        return NoName;
    }
    public String getColorName()
    {
        return  ColorName;
    }
    public int getIndex() {return index;}
}
public class Huluwa extends Creature implements Comparable
{
    private HuluAttribute huluAttribute;
    private int index;

    public HuluAttribute getAttribute()
    {
        return this.huluAttribute;
    }
    public int getIndex()
    {
        return this.index;
    }
    Huluwa(int index, HuluAttribute huluAttribute)
    {
        super();
        this.species = Species.HULUWA;
        this.index = index;
        this.huluAttribute = huluAttribute;
    }
    @Override
    public void report()
    {
        System.out.print(this.toString());
    }
    @Override
    public String toString()
    {
        return huluAttribute.getNoName();
    }
    @Override
    public boolean biggerThan(Comparable brother)
    {
        if (brother instanceof Huluwa)
        {
            return (this.index > ((Huluwa) brother).getIndex());
        }
        else return false;
    }
}