package huluwa;

public class HeYiFormation extends Formation{
    public HeYiFormation(int n,int m)
    {
        initial(n,m);
        stand();
    }
    public void stand()
    {
        Scorpion scorpion = new Scorpion();
        scorpion.sit(positions[0][num/2]);
        int col = num/2;

        for(int t = 1;t<num&&t*2<=LouLuoNum;t++)
        {
            XiaoLouLuo xt1 = new XiaoLouLuo();
            xt1.sit(positions[t][col-t]);
            XiaoLouLuo xt2 = new XiaoLouLuo();
            xt1.sit(positions[t][col+t]);
        }
    }
}
