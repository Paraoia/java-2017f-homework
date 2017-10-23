public class SORT {

    void bubblesort(Calabash brothers[])
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7-i-1;j++)
            {
                if(brothers[j].getRank()>brothers[j+1].getRank())
                {
                    int pos1=j;
                    int pos2=j+1;
                    brothers[j].reportchangingposition(pos1,pos2);
                    brothers[j+1].reportchangingposition(pos2,pos1);

                    brothers[j].hop(brothers,j+1);
                }
            }
        }


    }

    void quicksort(Calabash brothers[],int low,int high)
    {
        int l=low;
        int h=high;
        int pivot = brothers[low].getCrank().ordinal();

        while(l<h)
        {
            while(l<h&&brothers[h].getCrank().ordinal()>=pivot) {
                h--;
            }
                if(l<h)
                {
                    int pos1=h;
                    int pos2=l;
                    brothers[h].reportchangingposition(pos1,pos2);
                    brothers[l].reportchangingposition(pos2,pos1);

                    brothers[h].hop(brothers,l);
                    l++;
                }


            while(l<h&&brothers[l].getCrank().ordinal()<=pivot)
                l++;

            if(l<h)
            {
                int pos1=h;
                int pos2=l;
                brothers[h].reportchangingposition(pos1,pos2);
                brothers[l].reportchangingposition(pos2,pos1);

                brothers[h].hop(brothers,l);
                h--;
            }
        }

        if(l>low)
            quicksort(brothers,low,h-1);
        if(h<high)
            quicksort(brothers,h+1,high);
    }

    void print(Calabash brothers[],int flag)
    {
        //flag为0，即报告颜色，flag为1，即报告位置
        for(int i=0;i<7;i++) {
            if(flag==0)
                brothers[i].reportrank();
            else if (flag==1)
                brothers[i].reportpos();
        }
        System.out.println();
    }


}
