public class HuLu {

  private   int     rank;
  private   int     color;
    
  private   final String[]  RANK =  {"老大","老二","老三","老四","老五","老六","老七"};
  private   final String[]  COLOR = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};

    HuLu(int rank, int color)
    {
        this.rank   = rank;
        this.color  = color;
    }

    HuLu(HuLu hulu)
    {
        this.rank = hulu.rank;
        this.color = hulu.rank;
    }

    public void tellRank()
    {
        System.out.print(RANK[rank]);
    }

    public void tellColor()
    {
        System.out.print(COLOR[color]);
    }

    public int getRank() {
        return rank;
    }


    public int getColor()
    {
        return color;
    }


}
