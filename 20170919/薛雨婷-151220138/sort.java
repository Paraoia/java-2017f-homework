public class sort {
    public static  void main(String[] args){
        brothers ONE=new brothers("老大","红色");
        brothers TWO=new brothers("老二","橙色");
        brothers THREE=new brothers("老三","黄色");
        brothers FOUR=new brothers("老四","绿色");
        brothers FIVE=new brothers("老五","青色");
        brothers SIX=new brothers("老六","蓝色");
        brothers SEVEN=new brothers("老七","紫色");

        brothers brother1[]={FOUR,SIX,SEVEN,ONE,TWO,FIVE,THREE};
        BubbleSort(brother1);
        for(int i=0;i<7;i++)
            System.out.print(brother1[i].get_name()+"  ");
        System.out.println();

        brothers brother2[]={FOUR,SIX,SEVEN,ONE,TWO,FIVE,THREE};
        QuickSort(brother2,0,6);
        for(int i=0;i<7;i++)
            System.out.print(brother2[i].get_color()+"  ");
        System.out.println();
    }

    static void BubbleSort(brothers brother[]){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(brother[j].get_num()>brother[j+1].get_num()){
                    brothers temp=brother[j];
                    brother[j]=brother[j+1];
                    brother[j+1]=temp;
                    System.out.println(brother[j].get_name()+": "+j+" -> "+(j+1));
                    System.out.println(brother[j+1].get_name()+": "+(j+1)+" -> "+j);
                }
            }
        }
    }

    static void QuickSort(brothers brother[],int low,int high){
        if(low<high){
            int par=partition(brother,low,high);
            QuickSort(brother,low,par-1);
            QuickSort(brother,par+1,high);
        }
        return;
    }
    static int partition(brothers brother[],int low,int high){
        brothers pivot=brother[low];
        int sta=low;
        while(low<high){
            while(brother[high].get_num()>=pivot.get_num()&&high>low)
                high--;
            if(low!=high) {
                brother[low] = brother[high];
                System.out.println(brother[high].get_color() + ": " + high + " -> " + low);
            }
            while(brother[low].get_num()<=pivot.get_num()&&high>low)
                low++;
            if(low!=high) {
                brother[high] = brother[low];
                System.out.println(brother[low].get_color() + ": " + low + " -> " + high);
            }
        }
        if(high!=sta) {
            brother[high] = pivot;
            System.out.println(pivot.get_color() + ": " + sta + " -> " + high);
        }
        return high;
    }
}
