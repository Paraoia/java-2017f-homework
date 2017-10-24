public class God {
    Position [] Heye;
    CucurbitBrother [] SevenBros;

    void initial() {
        Heye=new Position[7];
        SevenBros=new CucurbitBrother[7];

        for (int i=0;i<7;i++){
            //上帝一开始按照随机的顺序创造了七个葫芦兄弟
            java.util.Random random=new java.util.Random();
            int r=random.nextInt(7);
            while(!Check(i,r)){
                r=random.nextInt(7);
            }
            SevenBros[i]=new CucurbitBrother(r);

            //每个葫芦兄弟造好后跳到了一片荷叶上
            SevenBros[i].jump(i);
            Heye [i]=new Position(i,SevenBros[i]);

        }
    }

    boolean Check(int num,int rank){
        for(int i=num-1;i>=0;i--)
            if(SevenBros[i].getRank()==rank)
                return false;
        return true;
    }

    //冒泡排序
    void BubbleSort()
    {
        //交换时先创造出一片新的荷叶,序号为7号
        Position tempHeye=new Position(7);

        for(int i=0;i<7;i++)
            for(int j=0;j<7-i-1;j++){
                if(Heye[j].getSomeone().getRank()>Heye[j+1].getSomeone().getRank()) {

                    Heye[j].getSomeone().SpeakYourName();
                    System.out.printf(":%d->%d\n",j,j+1);

                    //让j荷叶的葫芦娃跳上新的荷叶
                    Heye[j].getSomeone().jump(7);
                    tempHeye.ChangeSomeone( Heye[j].getSomeone());
                    Heye[j].ChangeSomeone(null);

                    //让j+1葫芦娃跳上j荷叶
                    Heye[j+1].getSomeone().jump(j);
                    Heye[j].ChangeSomeone(Heye[j+1].getSomeone());
                    Heye[j+1].ChangeSomeone(null);

                    //让新荷叶上的葫芦娃跳上j+1荷叶
                    tempHeye.getSomeone().jump(j+1);
                    Heye[j+1].ChangeSomeone(tempHeye.getSomeone());
                    tempHeye.ChangeSomeone(null);
                }
            }
    }


    //快排
    void QuickSort(){
        quickSort(0,6);
    }
    void quickSort(int beg,int end){
        if(beg<end){
            int par=Partition(beg,end);
            quickSort(beg,par-1);
            quickSort(par+1,end);
        }
    }
    int Partition(int beg,int end) {
        int start=beg;
        Position tmp = new Position(7);

        Heye[beg].getSomeone().jump(7);
        tmp.ChangeSomeone(Heye[beg].getSomeone());
        Heye[beg].ChangeSomeone(null);

        while (beg < end){
            while(end>beg&&Heye[end].getSomeone().getRank()>tmp.getSomeone().getRank())
                end--;

            //Heye[beg]=Heye[end];
            if(beg<end){
                Heye[end].getSomeone().SpeakYourName();
                System.out.printf(":%d->%d\n",end,beg);

                Heye[end].getSomeone().jump(beg);
                Heye[beg].ChangeSomeone(Heye[end].getSomeone());
                Heye[end].ChangeSomeone(null);
            }

            while(beg<end && Heye[beg].getSomeone().getRank()<tmp.getSomeone().getRank())
                beg++;

            //Heye[end]=Heye[beg];
            if(beg<end){
                Heye[beg].getSomeone().SpeakYourName();
                System.out.printf(":%d->%d\n",beg,end);

                Heye[beg].getSomeone().jump(end);
                Heye[end].ChangeSomeone(Heye[beg].getSomeone());
                Heye[beg].ChangeSomeone(null);
            }
        }

        //Heye[beg]=tmp;
        tmp.getSomeone().SpeakYourName();
        System.out.printf(":%d->%d\n",start,beg);

        tmp.getSomeone().jump(beg);
        Heye[beg].ChangeSomeone(tmp.getSomeone());
        tmp.ChangeSomeone(null);

        return beg;
    }


    public static void main(String[] args) {
        God god=new God();
        god.initial();
        System.out.print("冒泡排序前的初始站位:");
        for(int i=0;i<7;i++)
            System.out.print(god.Heye[i].getSomeone().getRank());
        System.out.println();
        god.BubbleSort();
        for(int i=0;i<7;i++) {
            god.Heye[i].getSomeone().SpeakYourName();
            System.out.print(" ");
        }
        System.out.println();

        //重新排队
        god.Heye[0].ChangeSomeone(god.SevenBros[4]);
        god.SevenBros[4].jump(0);
        god.Heye[1].ChangeSomeone(god.SevenBros[3]);
        god.SevenBros[3].jump(1);
        god.Heye[2].ChangeSomeone(god.SevenBros[6]);
        god.SevenBros[6].jump(2);
        god.Heye[3].ChangeSomeone(god.SevenBros[2]);
        god.SevenBros[2].jump(3);
        god.Heye[4].ChangeSomeone(god.SevenBros[0]);
        god.SevenBros[0].jump(4);
        god.Heye[5].ChangeSomeone(god.SevenBros[1]);
        god.SevenBros[1].jump(5);
        god.Heye[6].ChangeSomeone(god.SevenBros[5]);
        god.SevenBros[5].jump(6);

        System.out.print("快速排序前的初始站位:");
        for(int i=0;i<7;i++)
            System.out.print(god.Heye[i].getSomeone().getRank());
        System.out.println();
        god.QuickSort();
        for(int i=0;i<7;i++) {
            god.Heye[i].getSomeone().SpeakYourColor();
            System.out.print(" ");
        }
    }
}
