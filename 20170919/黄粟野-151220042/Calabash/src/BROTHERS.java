import java.util.Collection;

public class BROTHERS {
    Calabash[] brothers;

    BROTHERS()
    {

    }

    void initialize()
    {
        brothers = new Calabash[7];
        for(int i=0;i<7;i++)
        {
            brothers[i]=new Calabash(0,CoLor.red,RANK.one);
        }
        RandomTest random=new RandomTest();

        for(int i=0;i<7;i++)
        {
            int position=random.producerandom();

            while(brothers[position].getRank()!=0)
                position=(position+1)%7;

            Calabash temp=new Calabash(i);
            brothers[position] = temp;

        }
        //for(int i=0;i<7;i++)
          //  System.out.println(brothers[i].getRank()+" "+brothers[i].getCrank().getName()+" "+brothers[i].getName().getName());

    }

    public static void main(String[] args)
    {
        SORT test= new SORT();
        BROTHERS t1= new BROTHERS();
        t1.initialize();
        System.out.println("冒泡排序：");
        test.bubblesort(t1.brothers);
        t1.initialize();
        System.out.println("快速排序");
        test.quicksort(t1.brothers,0,6);
        test.print(t1.brothers);
    }
}
