import java.util.Random;
public class Brothers {
    private Calabash[] brothers;
    Brothers() {
        brothers = new Calabash[7];
       //生成随机数组
        int[] s=new int[7];
        for(int i=0;i<7;i++)
        {
            s[i]=i;
        }
        Random random = new Random();
        for(int i=0;i<7;i++){
            int n=random.nextInt(7);
            int temp=s[i];
            s[i]=s[n];
            s[n]=temp;
        }
        for(int i=0;i<7;i++)
        {
            brothers[i]= new Calabash(s[i]);
        }
        /*brothers[0]= new Calabash(2);
        brothers[1]=new Calabash(4);
        brothers[2]=new Calabash(0);
        brothers[3]=new Calabash(6);
        brothers[4]=new Calabash(5);
        brothers[5]=new Calabash(1);
        brothers[6]=new Calabash(3);*/
    }

    private void bubblesort()
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7-i-1;j++)
            {
                if(brothers[j].getRank().ordinal()>brothers[j+1].getRank().ordinal())
                {
                    brothers[j].Count_off();
                    System.out.println(":"+j+"->"+(j+1));
                    brothers[j+1].Count_off();
                    System.out.println(":"+(j+1)+"->"+j);
                    Calabash bro=brothers[j];
                    brothers[j]=brothers[j+1];
                    brothers[j+1]=bro;
                }
            }
        }
    }
    private void quicksort(int first,int last)
    {
        if (first >= last)
            return;
        int low = first;
        int high = last;
        Calabash key = brothers[first];
        while (low < high)
        {
            while (brothers[high].getColor().ordinal() >=key.getColor().ordinal() && low < high)
            {
                high--;
            }
            if(low<high) {
                Calabash bro = brothers[low];
                brothers[low] = brothers[high];
                brothers[high] = bro;
                brothers[high].Count_off();
                System.out.println(":" + high + "->" + low);
                brothers[low].Count_off();
                System.out.println(":" + low + "->" + high);
            }
            while (brothers[low].getColor().ordinal() <= key.getColor().ordinal() && low < high)
            {
                low++;
            }
            if(low<high) {
                Calabash bro = brothers[low];
                bro = brothers[low];
                brothers[low] = brothers[high];
                brothers[high] = bro;
                brothers[high].Count_off();
                System.out.println(":" + high + "->" + low);
                brothers[low].Count_off();
                System.out.println(":" + low + "->" + high);
            }
        }
        quicksort(first, low - 1);
        quicksort(low+1, last);
    }
    private void Count_off()
    {
        for(int i=0;i<7;i++)
        {
            brothers[i].Count_off();
        }
    }
    private void Color_off()
    {
        for(int i=0;i<7;i++)
        {
            brothers[i].Color_off();
        }
    }
    void sortbyname()
    {
        bubblesort();
        Count_off();
    }
    void sortbycolor()
    {
        quicksort(0,6);
        Color_off();
    }

    public static void main(String[] args) {
        Brothers b1=new Brothers();
        Brothers b2=new Brothers();
        b1.sortbyname();
        System.out.println();
        b2.sortbycolor();

    }

}
