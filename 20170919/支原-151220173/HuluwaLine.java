public class HuluwaLine{
    public Line[] line;
    void initalize()
    {
        line=new Line[7];
        for(int i=0;i<7;i++)
        {
            line[i]=new Line(i+1);
            Huluwa boy=new Huluwa(i+1);
            //boy.line_index=i+1;
            line[i].holder=boy;

        }

    }
    void randomline()
    {
        int[] order = new int[7];
        int num = (int) (Math.random() * 7);
        int size = 1;
        order[0] = num;
        while (true) {
            num = (int) (Math.random() * 7);
            boolean isHave = false;
            for (int j = 0; j < size; j++) {
                if (num == order[j]) {
                    isHave = true;
                    break;
                }
            }
            if (!isHave) {
                order[size] = num;
                size++;
            }
            if (size == 7) {
                break;
            }
        }
        Line[] randomline=new Line[7];
        for(int i=0;i<7;i++)
        {
            randomline[i]=new Line(i+1);
            randomline[i].holder=line[order[i]].holder;

        }

        line=randomline;
    }
    void reportName()
    {
        System.out.println("After being sorted,it is time to report their name");
        for(int i=0;i<7;i++) {
         line[i].holder.TellName();
        }
        System.out.println();

    }
    void reportColor()
    {
        System.out.println("After being sorted,it is time to report their color");
        for(int i=0;i<7;i++)
        {
            line[i].holder.TellColor();
        }
        System.out.println();
    }
    void bubblesort() {

        System.out.println("when they are sorted,the process is");
        for (int i = 0; i < 7; i++) {
            for (int j = 6; j > i; j--) {
                if (line[i].holder.range > line[j].holder.range) {
                    line[i].holder.jump(line[i].holder.col.GetName(),i+1,j+1);
                    line[j].holder.jump(line[j].holder.col.GetName(),j+1,i+1);
                    Huluwa temp=line[i].holder;
                    line[i].holder=line[j].holder;
                    line[j].holder=temp;


                }
            }
        }

        }

    public int partition(int lo,int hi)
    {
        int pivot=lo;
        Huluwa key=line[lo].holder;
        while(lo<hi){
            while(line[hi].holder.range>=key.range&&hi>lo)
            {
                hi--;
            }
            if(hi!=lo) {
               // System.out.println(Huluwa.line[hi].name + " " + hi + "->" + lo);
                line[hi].holder.jump(line[hi].holder.col.GetName(),hi+1,lo+1);
                line[lo].holder.jump(line[lo].holder.col.GetName(),lo+1,hi+1);
                Huluwa temp=line[lo].holder;
                line[lo].holder = line[hi].holder;
                line[hi].holder=temp;
            }
            while(line[lo].holder.range<=key.range&&hi>lo)
            {
                lo++;
            }
            if(hi!=lo) {
               // System.out.println(Huluwa.line[lo].name + " " + lo + "->" + hi);
                line[lo].holder.jump(line[lo].holder.col.GetName(),lo+1,hi+1);
                line[hi].holder.jump(line[hi].holder.col.GetName(),hi+1,lo+1);
                Huluwa temp=line[lo].holder;
                line[lo].holder = line[hi].holder;
                line[hi].holder=temp;
            }
        }
        if(hi!=lo) {
            //System.out.println(key.name + " " + lo + "->" + hi);
           // line[hi].holder = key;
            line[pivot].holder.jump(line[pivot].holder.col.GetName(),pivot+1,hi+1);
            line[hi].holder.jump(line[hi].holder.col.GetName(),hi+1,pivot+1);
            Huluwa temp=line[hi].holder;
            key=line[hi].holder;
            line[hi].holder=key;
        }
        return hi;
    }

    public void quicksort(int lo ,int hi)
    {
        if(lo>=hi)
        {
            return ;
        }
        int index=partition(lo,hi);
        quicksort(lo,index-1);
        quicksort(index+1,hi);


    }
}

