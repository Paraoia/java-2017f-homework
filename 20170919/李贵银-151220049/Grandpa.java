import java.util.Random;

public class Grandpa {
    huluwa[] hu=new huluwa[7];
    public void  initial()
    {   Random random=new Random();
        int []a=new int[7];
        boolean []b=new boolean[7];
        for(int i=0;i<7;i++)
            b[i]=false;
        for(int i=0;i<7;i++)
        {   int t;
            t=random.nextInt(7);
            while(b[t]==true)
                t=random.nextInt(7);
            a[i]=t;
            b[t]=true;
            //System.out.print(a[i]+" ");
        }
        random=null;
        hu[a[0]]=new huluwa(1,"红色",a[0]);
        hu[a[1]]=new huluwa(2,"橙色",a[1]);
        hu[a[2]]=new huluwa(3,"黄色",a[2]);
        hu[a[3]]=new huluwa(4,"绿色",a[3]);
        hu[a[4]]=new huluwa(5,"青色",a[4]);
        hu[a[5]]=new huluwa(6,"蓝色",a[5]);
        hu[a[6]]=new huluwa(7,"紫色",a[6]);
        //for(int i=0;i<7;i++)
          //  System.out.print(hu[i].position1+" ");
    }
    public void bubble()
    {
        for(int i=0;i<hu.length-1;i++)
            for(int j=0;j<hu.length-1-i;j++)
                if(hu[j].G_n()>hu[j+1].G_n())
                {
                   huluwa t=hu[j];
                   hu[j].xin(j+1);
                   hu[j].baoshu3();
                   hu[j]=hu[j+1];
                   hu[j+1].xin(j);
                   hu[j+1].baoshu3();
                    hu[j+1]=t;
                }
        for(int i=0;i<hu.length;i++)
            hu[i].baoshu1();
    }
    public void quick(int low,int high)
    {
        if(low>=high)
            return;
        int first=low,last=high;
        huluwa key=hu[first];
        int pos=first;
        while(first<last)
        {
            while(first<last&&hu[last].G_n()>=key.G_n())
                --last;
            hu[first].xin(last);
            //hu[first].baoshu3();
            hu[first]=hu[last];
            hu[last].xin(first);
            hu[last]=key;
            if(first!=last)
            {
                hu[first].baoshu3();
                hu[last].baoshu3();
            }
            while(first<last&&hu[first].G_n()<=key.G_n())
                ++first;
            hu[last].xin(first);
            hu[last]=hu[first];
            hu[first].xin(last);
            hu[first]=key;
            if(last!=first)
            {
                hu[last].baoshu3();
                hu[first].baoshu3();
            }
        }
        hu[first]=key;
        quick(low,first-1);
        quick(first+1,high);
    }
    public void quick_bs()
    {
        for(int i=0;i<hu.length;i++)
            hu[i].baoshu2();
    }
}
