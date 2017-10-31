import java.util.*;
import java.util.Date;
import java.util.GregorianCalendar;
//import Huluwa.java;

public class Queue{
    public Position[] positions=new Position[8];

    public void enqueue(Huluwa[] huluwas) {

//        if (huluwas.length > this.positions.length) {
//            return; //actually should throw exception
//       }

        positions[1]=new Position();
        positions[2]=new Position();
        positions[3]=new Position();
        positions[4]=new Position();
        positions[5]=new Position();
        positions[6]=new Position();
        positions[7]=new Position();
        positions[1].holder = huluwas[0];
        positions[2].holder = huluwas[2];
        positions[3].holder = huluwas[6];
        positions[4].holder = huluwas[4];
        positions[5].holder = huluwas[3];
        positions[6].holder = huluwas[5];
        positions[7].holder = huluwas[1];

        //留个空位
        positions[0]=new Position();
        positions[0].holder = null;

        //...

    }

    public void sort(Huluwa[] huluwas) {

    //    Huluwa huluwa;
  /*      for (int i = 1; i < positions.length; i++) {
            huluwa = positions[i].holder;
            j = i - 1;
            //如果huluwa小于后端数，那后端的数要顺移
            while (j >= 0 && huluwa.seniority < positions[j].holder.seniority) {
                positions[j + 1].holder = positions[j--].holder;
            }
            //将huluwa插入到指定位置
            positions[j + 1].holder = huluwa;
        }
        */
        for(int i=0;i<7;i++)
            for(int j=1;j<8-i-1;j++)
            {
                if(positions[j].holder.seniority>positions[j+1].holder.seniority){
                    System.out.println(positions[j+1].holder.name+":"+(j+1)+"->"+j);
                    System.out.println(positions[j].holder.name+":"+j+"->"+(j+1));
                    Huluwa temp=positions[j].holder;
                    positions[j].holder=positions[j+1].holder;
                    positions[j+1].holder=temp;
                }
            }

        for(int i=1;i<8;i++)
        {
            System.out.println(positions[i].holder.name);
        }


}

    public void print_result()
    {
        for(int i=1;i<8;i++)
        {
            if(positions[i].holder.color==COLOR.CHI)
                System.out.println("红色");
            if(positions[i].holder.color==COLOR.CHENG)
                System.out.println("橙色");
            if(positions[i].holder.color==COLOR.HUANG)
                System.out.println("黄色");
            if(positions[i].holder.color==COLOR.LV)
                System.out.println("绿色");
            if(positions[i].holder.color==COLOR.QING)
                System.out.println("青色");
            if(positions[i].holder.color==COLOR.LAN)
                System.out.println("蓝色");
            if(positions[i].holder.color==COLOR.ZI)
                System.out.println("紫色");
        }
    }
    public int q_sort(Huluwa[] huluwas,int low,int high)
    {
        int pivot=positions[low].holder.seniority;
//        System.out.println(positions[low].holder.seniority);
//        System.out.println(positions[high].holder.seniority);
        Huluwa temp=positions[low].holder;
        while(low<high)
        {
            while(positions[high].holder.seniority>=pivot&&high>low)
            {
                high--;
            }
            if(positions[high].holder.seniority!=positions[low].holder.seniority&&high!=low)
            {
                System.out.println(positions[high].holder.name+":"+high+"->"+low);
                System.out.println(positions[low].holder.name+":"+low+"->"+high);
            }
            positions[low].holder=positions[high].holder;

            while(positions[low].holder.seniority<=pivot&&high>low)
            {
                low++;
            }
            if(positions[high].holder.seniority!=positions[low].holder.seniority&&high!=low)
            {
                System.out.println(positions[high].holder.name+":"+high+"->"+low);
                System.out.println(positions[low].holder.name+":"+low+"->"+high);
            }
            positions[high].holder=positions[low].holder;

        }
        if(positions[high].holder.seniority!=temp.seniority&&high!=pivot)
        {
            System.out.println(positions[high].holder.name+":"+high+"->"+pivot);
            System.out.println(temp.name+":"+pivot+"->"+high);

        }
        positions[high].holder=temp;

        return high;
    }

    public void quicksort(Huluwa[] huluwas,int low,int high)
    {
           if(low>=high)
           {
               return;
           }
           int curr=q_sort(huluwas,low,high);
       //     System.out.println(curr+"   "+low+"    "+high+"    ");
           quicksort(huluwas,low,curr-1);
           quicksort(huluwas,curr+1,high);
    }

    public static void main(String args[])
    {
        Huluwa[] huluwas=new Huluwa[7];
        huluwas[0] = new Huluwa();
        huluwas[0].color= COLOR.CHI;
        huluwas[0].name="老大";
        huluwas[0].seniority=1;
        huluwas[1] = new Huluwa();
        huluwas[1].color=COLOR.CHENG;
        huluwas[1].name="老二";
        huluwas[1].seniority=2;
        huluwas[2] = new Huluwa();
        huluwas[2].color=COLOR.HUANG;
        huluwas[2].name="老三";
        huluwas[2].seniority=3;
        huluwas[3] = new Huluwa();
        huluwas[3].color=COLOR.LV;
        huluwas[3].name="老四";
        huluwas[3].seniority=4;
        huluwas[4] = new Huluwa();
        huluwas[4].color=COLOR.QING;
        huluwas[4].name="老五";
        huluwas[4].seniority=5;
        huluwas[5] = new Huluwa();
        huluwas[5].color=COLOR.LAN;
        huluwas[5].name="老六";
        huluwas[5].seniority=6;
        huluwas[6] = new Huluwa();
        huluwas[6].color=COLOR.ZI;
        huluwas[6].name="老七";
        huluwas[6].seniority=7;
        Queue s = new Queue();
        s.enqueue(huluwas);
        s.sort(huluwas);
        s.enqueue(huluwas);
        s.quicksort(huluwas,1,7);
        s.print_result();
    }

class Position {
    public int index;
    public Huluwa holder;
}

}