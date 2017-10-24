//import java.Huluwa;

public class Queue {

    private Huluwa[] brother = new Huluwa[8];

    Queue(){
        for(int i = 0;i < 8;i++){
            brother[i] = new Huluwa(i,i);
        }
    }

    public void reset(){//打乱葫芦娃顺序
        int[] flag = new int[]{0,0,0,0,0,0,0,0};
        java.util.Random r = new java.util.Random();
        for(int i = 1;i <= 7;i++){
            int num = r.nextInt(100)%7 + 1;
            while (flag[num] == 1) num = (num + 1)%7 + 1;
            flag[num] = 1;
            brother[num] = new Huluwa(i,i);
        }
        System.out.print("排序前：");
        show();
    }

    public void show(){//葫芦娃队列报数
        for(int i = 1;i <= 7;i++){
            System.out.print(i+":"+brother[i].repName()+brother[i].repColor()+" ");
        }
        System.out.print("\n");
    }

    public void exchange(int pos1,int pos2){//交换葫芦娃位置
        int color = brother[pos1].gcolor();
        int name = brother[pos1].gname();
        brother[pos1] = brother[pos2];
        brother[pos1].reportmove(pos2,pos1);
        brother[pos2] = new Huluwa(name,color);
        brother[pos2].reportmove(pos1,pos2);
        System.out.print("\n");
    }

    public void bubblesort(){//冒泡排序
        System.out.print("冒泡排序：\n");
        for(int i = 1;i < 7;i++){
            int temp = i;
            for(int j = i+1;j <= 7;j++){
                if(brother[temp].gname() > brother[j].gname())
                    temp = j;
            }
            if(temp != i)
                exchange(temp,i);
        }
    }

    public int partition(int low,int high){
        int temp = low;
        Huluwa pivot = brother[low];
        while(low < high){
            while(low < high && brother[high].gcolor() >= pivot.gcolor()) --high;
            brother[low] = brother[high];
            if(low != high) brother[low].reportmove(high,low);
            while(low < high && brother[low].gcolor() <= pivot.gcolor()) ++low;
            brother[high] = brother[low];
            if(high != low) brother[high].reportmove(low,high);
        }
        brother[low] = new Huluwa(pivot.gname(),pivot.gcolor());
        if(temp != low) brother[low].reportmove(temp,low);
        return low;
    }

    public void qsort(int low,int high){
        if(low < high){
            int pivot = partition(low,high);
            qsort(low,pivot-1);
            qsort(pivot+1,high);
        }
    }

    public void quicksort(){//快速排序
        System.out.print("快速排序：\n");
        qsort(1,7);
        System.out.print("\n");
    }

    //public void BinaryInsertSort()

}
