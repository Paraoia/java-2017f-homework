 abstract public class Queue //抽象类：某生物队列
{
    public int num; //队列人数 （不能是static 否则所有继承类都为相同值）
    public Creature []creatures; //队列中的生物数组
    Position []positions; //队列占据的位置的引用构成的数组
    Formation form; //表示队列当前队形的对象

    public Position[] getPositions()
    {
        return positions;
    }
    public void Swap(Position p1, Position p2) //位于位置p1和p2的两个生物交换位置
    {
        Creature temp1 = p1.getHolder();
        Creature temp2 = p2.getHolder();
        temp1.leavePosition(); //离开位置
        temp2.leavePosition(); //离开位置
        temp1.setPosition(p2);
        temp2.setPosition(p1);
    }
    public void FormationChange(Formation form) //变换队形
    {
        this.form = form;
        positions = form.positions;
        for(Creature cr :creatures) //所有生物离开当前位置
        {
            cr.leavePosition();
        }
        for(int i = 0; i < num; i ++)
        {
            creatures[i].setPosition(positions[i]);
        }
    }
}

