public class Huluwa implements creature {
    private COLOR color;
    private SENIORITY seniority;
    private Position position;

    @Override
    public String getName()
    {
        return "老" + seniority.toString();
    }

    public Huluwa(COLOR color, SENIORITY seniority)
    {
        this.color = color;
        this.seniority = seniority;
    }

    @Override
    public void setPosition(Position position)
    {
        if(this.position!=null)
            this.position.setHolder(null);
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public Position getPosition()
    {
        return position;
    }
}

enum COLOR{
    红,橙,黄,绿,青,蓝,紫
}

enum SENIORITY {
    一,二,三,四,五,六,七
}