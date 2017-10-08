import java.util.*;


/*
* @author Minhui Xie
* @date 20,09,2017
* @time 21:57
*/
public class Grandpa {

    List<Hulu>  huluwas;
    public static void main(String[] args) {
        Grandpa grandpa=new Grandpa();
        grandpa.rollCall();
        grandpa.bubbleSort();
        grandpa.quickSort();
    }

    Grandpa()   {
        huluwas=new ArrayList<Hulu>();
        huluwas.add(new Hulu(1,
                new String("大娃"),new String("赤"),0));
        huluwas.add(new Hulu(2,
                new String("二娃"),new String("橙"),1));
        huluwas.add(new Hulu(3,
                new String("三娃"),new String("黄"),2));
        huluwas.add(new Hulu(4,
                new String("四娃"),new String("绿"),3));
        huluwas.add(new Hulu(5,
                new String("五娃"),new String("青"),4));
        huluwas.add(new Hulu(6,
                new String("六娃"),new String("蓝"),5));
        huluwas.add(new Hulu(7,
                new String("小娃"),new String("紫"),6));
    }

    //initial shuffling
    void initShuffle()
    {
        Random r=new Random();
        for(int i=0;i<10;i++)
        {
            int a=r.nextInt(7);int b=r.nextInt(7);
            huluwas.get(a).setPosition(b);
            huluwas.get(b).setPosition(a);
            Collections.swap(huluwas,a,b);
        }
    }

    void rollCall()
    {
        //let huluwas echo in position-based turn
        for(Hulu temp:huluwas)
        {
            temp.echo();
        }
    }
    void bubbleSort() {
        System.out.println("----------Bubble Sort Begin-------------");
        initShuffle();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6-i; j++)
            {
                if(huluwas.get(j).getNumRank()>huluwas.get(j+1).getNumRank())
                {
                    huluwas.get(j).changePosition(j+1);
                    huluwas.get(j+1).changePosition(j);
                    Collections.swap(huluwas,j,j+1);
                }
            }
        rollCall();
        System.out.println("----------Bubble Sort End-------------");
    }

    void quickSort()    {
        System.out.println("----------Quick Sort Begin-------------");
        initShuffle();
        quickSortAux(0,6);
        rollCall();
        System.out.println("----------Quick Sort End-------------");
    }

    void quickSortAux(int i,int j){
        if(i<j)
        {
            Hulu pivot=huluwas.get(j);
            int pivot_rank=pivot.getNumRank();
            int pos_le_pivot=i-1;
            for (int index=i;index<j;index++)
            {
                if(huluwas.get(index).getNumRank()<=pivot_rank)
                {
                    pos_le_pivot++;
                    //exchange huluwa[pos_le_pivot] with huluwas[index]
                    huluwas.get(pos_le_pivot).changePosition(index);
                    huluwas.get(index).changePosition(pos_le_pivot);
                    Collections.swap(huluwas,pos_le_pivot,index);
                }
            }
            //exchange huluwa[pos_le_pivot+1] with huluwas[j]
            huluwas.get(pos_le_pivot+1).changePosition(j);
            huluwas.get(j).changePosition(pos_le_pivot+1);
            Collections.swap(huluwas,pos_le_pivot+1,j);

            //divide and conquer
            quickSortAux(i,pos_le_pivot);
            quickSortAux(pos_le_pivot+2,j);
        }
    }
}
