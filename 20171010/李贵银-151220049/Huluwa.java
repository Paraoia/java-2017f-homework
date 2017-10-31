enum Color {
    红色,橙色,黄色,绿色,青色,蓝色,紫色
}
enum Name{
    老大,老二,老三,老四,老五,老六,老七
}
public class Huluwa extends Creature implements Comparable{
   private Color color;
   private int rank;
   Huluwa(int rank)
    {
        super(Name.values()[rank-1].toString());
        color=Color.values()[rank-1];
        this.rank=rank;
    }

    @Override
    public boolean biggerthan(Comparable another) {
       if(another instanceof Huluwa)
           return this.rank>((Huluwa) another).rank;
       else
           return false;
    }
}

