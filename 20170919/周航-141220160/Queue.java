import java.io.BufferedOutputStream;
import java.util.Random;

public class Queue {
    public  HuluBoy[] Boys;
    public Queue(){
        Boys=new HuluBoy[7];
        Boys[0]=new HuluBoy("老大",COLOR.CHI,1);
        Boys[1]=new HuluBoy("老二",COLOR.CHENG,2);
        Boys[2]=new HuluBoy("老三",COLOR.HUANG,3);
        Boys[3]=new HuluBoy("老四",COLOR.LV,4);
        Boys[4]=new HuluBoy("老五",COLOR.QING,5);
        Boys[5]=new HuluBoy("老六",COLOR.LAN,6);
        Boys[6]=new HuluBoy("老七",COLOR.ZI,7);
    }

    public void randomQ(){
        Random random=new Random();
        for(int i=0;i<7;i++){
            Boys[0].swap(Boys,i,random.nextInt(7));
        }
    }

    public void printName(){
        System.out.println("葫芦娃的站队顺序为：");
        for(int i=0;i<7;i++){
            System.out.print(Boys[i].getname()+" ");
        }
        System.out.println(" ");
    }

    public void printColor(){
        System.out.println("葫芦娃的站队顺序为：");
        for(int i=0;i<7;i++){
            Boys[i].getcolor();
        }
        System.out.println(" ");
    }

    public void bubbleSort(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(Boys[j].getrank()>Boys[j+1].getrank())Boys[j].printExchange(Boys,j,j+1);
            }
        }
        System.out.println(" ");

    }

    public int partition(int low,int high){
        int key=Boys[low].getrank();
        while(low<high){
            while(Boys[high].getrank()>=key&&high>low){
                high--;
            }
            Boys[low].printExchange(Boys,low,high);
            while(Boys[low].getrank()<=key&&high>low){
                low++;
            }
            Boys[low].printExchange(Boys,low,high);
        }
        return high;
    }


    public void quickSort(int low ,int high){
        if(low>=high){
            return ;
        }
        int index=partition(low,high);
        quickSort(low,index-1);
        quickSort(index+1,high);

    }
}
