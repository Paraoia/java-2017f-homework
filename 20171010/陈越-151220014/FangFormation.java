package huluwa;

public class FangFormation extends Formation{
    public FangFormation(int n,int m)
    {
        initial(n,m);
        stand();
    }
    public void stand()
    {
        Scorpion scorpion = new Scorpion();
        scorpion.sit(positions[0][num/2]);
        int col = num/2;
        for(int t = 1;t<=(LouLuoNum-1)/2-t+1;t++)
        {
            XiaoLouLuo xt1 = new XiaoLouLuo();
            xt1.sit(positions[t][col-t]);
            XiaoLouLuo xt2 = new XiaoLouLuo();
            xt1.sit(positions[t][col+t]);
            XiaoLouLuo xt3 = new XiaoLouLuo();
            xt3.sit(positions[(LouLuoNum-1)/2-t+1][col-t]);
            XiaoLouLuo xt4 = new XiaoLouLuo();
            xt4.sit(positions[(LouLuoNum-1)/2-t+1][col+t]);
        }
        XiaoLouLuo xt = new XiaoLouLuo();
        xt.sit(positions[LouLuoNum/2+1][col]);
    }
}
