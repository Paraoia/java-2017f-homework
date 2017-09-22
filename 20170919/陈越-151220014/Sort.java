package hulvwa;

import java.util.Random;

public class Sort {
    public static void main(String []args)
    {
        Sort sort = new Sort(7);
        sort.shuffle();
        sort.bubbleSort();
        sort.shuffle();
        sort.quickSort();
    }

    private hulvwa children[];
    private int num;
    Sort(int n)
    {
        num = n;
        children = new hulvwa[num];

    }
    private void printNum()
    {
        for(int i=0;i<num;i++)
        {
            children[i].printNum();
        }
    }
    private void printColor()
    {
        for(int i=0;i<num;i++)
        {
            children[i].printColor();
        }
    }
    public void shuffle()
    {
        Random ran = new Random();
        children[0] = new hulvwa(ran.nextInt(num)+1);
        int i=1;
        for(;i<num;i++)
        {
            int j = 0;
            while (j != i) {
                children[i] = new hulvwa(ran.nextInt(num) + 1);
                for (j = 0; j < i && children[j].no != children[i].no; j++) ;
            }
        }
    }

    public void bubbleSort()
    {
        for(int i = num-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(children[j+1].no<children[j].no)
                {
                    hulvwa temp = new hulvwa();
                    temp = children[j];
                    children[j]= children[j+1];
                    children[j+1]=temp;
                    children[j].myPrintln(j,j+1);
                    children[j+1].myPrintln(j+1,j);

                }
            }
        }
        printNum();
    }
    private int partition(int left,int right)
    {
        int pivotpos = left;
        hulvwa temp = new hulvwa();
        temp = children[left];
        for(int i=left+1;i<=right;i++)
        {
            if(children[i].no < temp.no)
            {
                pivotpos++;
                if(pivotpos!=i)
                {
                    hulvwa t = new hulvwa();
                    t = children[i];
                    children[i] = children[pivotpos];
                    children[pivotpos] = t;
                    children[i].myPrintln(i,pivotpos);
                    children[pivotpos].myPrintln(pivotpos,i);
                }
            }

        }
        children[left] = children[pivotpos];
        children[pivotpos].myPrintln(pivotpos,left);
        children[pivotpos] = temp;
        children[left].myPrintln(left,pivotpos);
        return pivotpos;
    }
    private void quickPartSort(int left,int right)
    {
        if(left < right)
        {
            int pivotpos = partition(left,right);
            quickPartSort(left,pivotpos-1);
            quickPartSort(pivotpos+1,right);
        }
    }
    public void quickSort()
    {
        quickPartSort(0,num-1);
        printColor();
    }
}
