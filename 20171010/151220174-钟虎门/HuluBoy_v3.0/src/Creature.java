public class Creature
{
    protected String creature_icon;
    public final String Grandpa_ICON=" 爷 ";
    public final String Scorpion_ICON=" 蝎 ";
    public final String Snake_ICON=" 蛇 ";
    public final String Bandit_ICON=" 喽 ";

    Creature()
    {
        creature_icon="    ";
    }

    String GetCreatureIcon()
    {
        return creature_icon;
    }

    void SetCreatureIcon()
    {
        creature_icon=" 空 ";
    }

    protected void show()
    {
        System.out.print(creature_icon);
    }
}

class HuluBoy extends Creature
{
    HuluBoy(int color)
    {
        //creature_icon=" H ";
        this.color=color;
        switch (this.color)
        {
            case 0:creature_icon=" 赤 ";break;
            case 1:creature_icon=" 橙 ";break;
            case 2:creature_icon=" 黄 ";break;
            case 3:creature_icon=" 绿 ";break;
            case 4:creature_icon=" 青 ";break;
            case 5:creature_icon=" 蓝 ";break;
            case 6:creature_icon=" 紫 ";break;
        }
    }
    HuluBoy()
    {
        creature_icon=" H ";
    }

    void SetCreatureIcon()
    {
        creature_icon=" H ";
    }

    private int color;//0-6:赤橙黄绿青蓝紫
}

class Grandpa extends Creature
{
    Grandpa()
    {
        creature_icon=Grandpa_ICON;
    }
    void SetCreatureIcon()
    {
        creature_icon=" G ";
    }
}

class Monster extends Creature
{
    Monster()
    {
        creature_icon=" M ";
    }
}

class Scorpion extends Monster
{
    Scorpion()
    {
        creature_icon=" 蝎 ";
    }
}

class Snake extends Monster
{
    Snake()
    {
        creature_icon=Snake_ICON;
    }
}

class Bandit extends Monster
{
    Bandit()
    {
        creature_icon=Bandit_ICON;
    }
}