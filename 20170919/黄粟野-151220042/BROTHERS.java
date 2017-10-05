import java.util.Collection;

public class BROTHERS {
    Calabash[] brothers;


    void initialize()
    {
        // 随机初始化七兄弟的位置
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

    }


    public static void main(String[] args)
    {
        SORT test= new SORT();
        BROTHERS t1= new BROTHERS();

        t1.initialize();
        System.out.println("冒泡排序：");
        test.bubblesort(t1.brothers);
        test.print(t1.brothers,1);

        t1.initialize();
        System.out.println("快速排序");
        test.quicksort(t1.brothers,0,6);
        test.print(t1.brothers,0);
    }


}
