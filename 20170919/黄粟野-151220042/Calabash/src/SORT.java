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
                    System.out.println(brothers[j].getName().getName()+":"+pos1+"->"+pos2);
                    System.out.println(brothers[j+1].getName().getName()+":"+pos2+"->"+pos1);
                    Calabash temp = new Calabash(brothers[j].getRank(),brothers[j].getCrank(),brothers[j].getName());
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = temp;
                }
            }
        }

        for(int i=0;i<7;i++)
            System.out.print(brothers[i].getName().getName()+" ");
        System.out.println();
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
                    System.out.println(brothers[h].getName().getName()+":"+pos1+"->"+pos2);
                    System.out.println(brothers[l].getName().getName()+":"+pos2+"->"+pos1);
                    Calabash temp=new Calabash(brothers[h].getRank(),brothers[h].getCrank(),brothers[h].getName());
                    brothers[h]=brothers[l];
                    brothers[l]=temp;
                    l++;
                }


            while(l<h&&brothers[l].getCrank().ordinal()<=pivot)
                l++;

            if(l<h)
            {
                int pos1=h;
                int pos2=l;
                System.out.println(brothers[h].getName().getName()+":"+pos1+"->"+pos2);
                System.out.println(brothers[l].getName().getName()+":"+pos2+"->"+pos1);
                Calabash temp=new Calabash(brothers[h].getRank(),brothers[h].getCrank(),brothers[h].getName());
                brothers[h]=brothers[l];
                brothers[l]=temp;
                h--;
            }
        }

        if(l>low)
            quicksort(brothers,low,h-1);
        if(h<high)
            quicksort(brothers,h+1,high);
    }

    void print(Calabash brothers[])
    {
        for(int i=0;i<7;i++)
        {
            System.out.print(brothers[i].getCrank().getName()+" ");
        }
        System.out.println();
    }


}
