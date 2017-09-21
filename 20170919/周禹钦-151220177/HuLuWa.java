/**
 * Created by qin on 17.9.20.
 */
public class HuLuWa {
    final static int red=1;
    final static int orange=2;
    final static int yellow=3;
    final static int green=4;
    final static int cyan_blue=5;
    final static int blue=6;
    final static int purple=7;
    private int Color;
    HuLuWa(int a){Color=a;}
    public void exchange(HuLuWa[] a,int m,int n){

       switch (a[m].Color) {
           case 1:System.out.print("老大:");break;
           case 2:System.out.print("老二:");break;
           case 3:System.out.print("老三:");break;
           case 4:System.out.print("老四:");break;
           case 5:System.out.print("老五:");break;
           case 6:System.out.print("老六:");break;
           case 7:System.out.print("老七:");break;
       }
       System.out.println(m +" -> "+n);
       int temp=a[m].Color;
       a[m].Color=a[n].Color;
       a[n].Color=temp;
    }
    public int get_color(){
        return Color;
    }
    public void BubbleSort(HuLuWa[] Ar){
        for (int i=0;i<7;i++){
            for (int j=i;j<7;j++){
                if (Ar[i].Color>Ar[j].Color)
                    Ar[i].exchange(Ar,j,i);
            }
        }
    }
    public void QuickSort(HuLuWa[] Ar){
        for (int i=0;i<7;i++){
            int temp=i;
            for (int j=temp+1;j<7;j++){
                if (Ar[temp].Color>Ar[j].Color)
                    temp=j;
            }
            if(i!=temp){
                Ar[i].exchange(Ar,temp,i);
            }
        }
    }
    public void PrintHuLuWa(boolean a,int n){
        if (a){
            switch (n) {
                case 1:System.out.print("老大 ");break;
                case 2:System.out.print("老二 ");break;
                case 3:System.out.print("老三 ");break;
                case 4:System.out.print("老四 ");break;
                case 5:System.out.print("老五 ");break;
                case 6:System.out.print("老六 ");break;
                case 7:System.out.print("老七 ");break;
            }
        }
        else{
            switch (n) {
                case 1:System.out.print("红色 ");break;
                case 2:System.out.print("橙色 ");break;
                case 3:System.out.print("黄色 ");break;
                case 4:System.out.print("绿色 ");break;
                case 5:System.out.print("青色 ");break;
                case 6:System.out.print("蓝色 ");break;
                case 7:System.out.print("紫色 ");break;
            }
        }
    }
    public static void main(String [] args){
        HuLuWa []Ar=new HuLuWa[7];
        Ar[0]=new HuLuWa(3);
        Ar[1]=new HuLuWa(2);
        Ar[2]=new HuLuWa(7);
        Ar[3]=new HuLuWa(4);
        Ar[4]=new HuLuWa(6);
        Ar[5]=new HuLuWa(1);
        Ar[6]=new HuLuWa(5);
        Ar[0].BubbleSort(Ar);

        for(HuLuWa e:Ar){
            e.PrintHuLuWa(true,e.get_color());
        }
        System.out.println();

        Ar[0]=new HuLuWa(6);
        Ar[1]=new HuLuWa(3);
        Ar[2]=new HuLuWa(4);
        Ar[3]=new HuLuWa(7);
        Ar[4]=new HuLuWa(1);
        Ar[5]=new HuLuWa(5);
        Ar[6]=new HuLuWa(2);
        Ar[0].QuickSort(Ar);

        for (HuLuWa e:Ar) {
            e.PrintHuLuWa(false,e.get_color() );
        }
        System.out.println();
    }
}
