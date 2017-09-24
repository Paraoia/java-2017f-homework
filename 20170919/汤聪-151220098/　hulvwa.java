package hulvwa;

import java.util.Random;


    public class hulvwa {
        public static void main(String[] args)
        {
            hulvwa boy=new hulvwa(7);
            hulvwa color=new hulvwa(7);
            boy.set();
            boy.bubblesort();
            color.set();
            System.out.println("快速排序过程：");
            color.QuickSort(0,color.length()-1);
            color.cout3();
        }
        private int n;
        private int p[];
        hulvwa(int k)
        {
            n=k;
            p=new int[n];
        }
        public int length()
        {
            int i=n;
            return i;
        }
        public void set()
        {
            Random r=new Random();
            for(int i=0;i<n;i++)
            {
                int r1=r.nextInt(n)+1;
                int j=0;
                for(j=0;j<i;j++)
                {
                    if(p[j]==r1)
                    {
                        r1=r.nextInt(n)+1;
                        j=-1;
                    }
                }
                p[i]=r1;
            }
            cout();
        }
        public void bubblesort()
        {
            System.out.println("冒泡排序过程：");
            for(int i=1;i<n;i++)
            {
                for(int j=n-1;j>=i;j--)
                {
                    if(p[j-1]>p[j])
                    {
                        int temp=p[j-1];
                        p[j-1]=p[j];
                        p[j]=temp;
                        cout2(p[j],j,j-1);
                        cout2(p[j-1],j-1,j);
                    }
                }
            }
            System.out.println("冒泡排序结果：");
            cout();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("------------------");
        }
        public void cout()
        {
            for(int i=0;i<n;i++)
            {
                switch (p[i])
                {
                    case 1:System.out.println("老大");break;
                    case 2:System.out.println("老二");break;
                    case 3:System.out.println("老三");break;
                    case 4:System.out.println("老四");break;
                    case 5:System.out.println("老五");break;
                    case 6:System.out.println("老六");break;
                    case 7:System.out.println("老七");break;
                }
            }
        }
        public void cout2(int m,int first,int last)
        {
            switch(m)
            {
                case 1:System.out.println("老大"+":"+first+"->"+last);break;
                case 2:System.out.println("老二"+":"+first+"->"+last);break;
                case 3:System.out.println("老三"+":"+first+"->"+last);break;
                case 4:System.out.println("老四"+":"+first+"->"+last);break;
                case 5:System.out.println("老五"+":"+first+"->"+last);break;
                case 6:System.out.println("老六"+":"+first+"->"+last);break;
                case 7:System.out.println("老七"+":"+first+"->"+last);break;
            }
        }
        public void cout3()
        {
            System.out.println("");
            System.out.println("快速排序结果:");
            for(int i=0;i<n;i++)
            {
                switch(p[i])
                {
                    case 1:System.out.println("红色");break;
                    case 2:System.out.println("橙色");break;
                    case 3:System.out.println("黄色");break;
                    case 4:System.out.println("绿色");break;
                    case 5:System.out.println("青色");break;
                    case 6:System.out.println("蓝色");break;
                    case 7:System.out.println("紫色");break;
                }
            }
        }
        /*public void BiSort()
        {
            int left=0;
            int right=n-1;
            int i,temp,low,high,middle,k;
            for(i=left+1;i<=right;i++ )
            {
                temp=p[i];
                low=left;
                high=i-1;
                while(low<=high)
                {
                    middle=(low+high)/2;
                    if(temp<p[middle])
                        high=middle-1;
                    else
                        low=middle+1;
                }
                for(k=i-1;k>=low;k--)
                    p[k+1]=p[k];
                p[low]=temp;
            }
        }*/
        public int Partition(int low,int high)
        {
            int pivotpos=low;
            int pivot=p[low];
            for(int i=low+1;i<=high;i++)
            {
                if(p[i]<pivot) {
                    pivotpos++;
                    if (pivotpos != i) {
                        int temp = p[pivotpos];
                        p[pivotpos] = p[i];
                        p[i] = temp;
                        cout2(p[pivotpos], pivotpos, i);
                        cout2(p[i], i, pivotpos);
                    }
                }
            }
            p[low]=p[pivotpos];
            p[pivotpos]=pivot;
            cout2(p[low],low,pivotpos);
            cout2(p[pivotpos],pivotpos,low);
            return pivotpos;
        }
        public void QuickSort(int left,int right)
        {
            if(left<right)
            {
                int pivotpos=Partition(left,right);
                QuickSort(left,pivotpos-1);
                QuickSort(pivotpos+1,right);
            }
        }
    }
