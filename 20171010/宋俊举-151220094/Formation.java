
enum FORMATIONS{
    HeYi,YanXing,ChongE,ChangShe
}


//阵型方法类
public class Formation {

    //鹤翼阵
    public static void setHeyi(creature[] c, Position[][] p, int refX, int refY)
    {
        for(int i=0;i<=c.length/2;i++)
        {
            c[i].setPosition(p[refX + i][refY + i]);
        }
        for(int i = c.length/2 + 1;i < c.length;i++)
        {
            c[i].setPosition(p[refX + c.length - i][refY + i]);
        }
    }

    //雁形阵
    public static void setYanxing(creature[] c, Position[][] p, int refX, int refY)
    {
        for(int i = 0;i < c.length;i++)
        {
            c[i].setPosition(p[refX + c.length - i - 1][refY + i]);
        }
    }

    //冲厄阵
    public static void setChonge(creature[] c, Position[][] p, int refX, int refY)
    {
        for(int i = 0;i < c.length;i++)
        {
            c[i].setPosition(p[refX + i][refY + i%2]);
        }
    }

    //长蛇阵
    public static void setChangshe(creature[] c, Position[][] p, int refX, int refY)
    {
        for(int i = 0;i < c.length;i++)
        {
            c[i].setPosition(p[refX + i][refY]);
        }
    }
    /*鱼鳞阵，未完成
    public static void setYulin(creature[] c, Position[][] p, int refX, int refY)
    {

    }
    */

    /*方斗？阵，未完成
    public static void setFangdou(creature[] c, Position[][] p, int refX, int refY)
    {

    }
     */

    /*偃月阵，未完成
    public static void setYanyue(creature[] c, Position[][] p, int refX, int refY)
    {

    }
     */

    /*冲矢阵，未完成
    public static void setChongshi(creature[] c, Position[][] p, int refX, int refY)
    {

    }
     */
}

