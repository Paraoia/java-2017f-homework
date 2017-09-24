package homework2;


public class huluwa {
    public int old;
    public String name;
    public int position;
    public String color;
    public huluwa(int n, String nm, String c, int p)
    {
        old = n;
        name = nm;
        color = c;
        position = p;
    }
    //打印位置变化
    public void changepos(int nowpos) {
        System.out.println(name+":"+position+"->"+(nowpos+1));
        position = nowpos + 1;
    }


}
