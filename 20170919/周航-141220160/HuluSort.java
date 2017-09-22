import java.util.Random;

public class HuluSort {
    HuluBoy Boys[];

    void init(){
        Boys=new HuluBoy[7];
        Boys[0]=new HuluBoy("老大","红色",1);
        Boys[1]=new HuluBoy("老二","橙色",2);
        Boys[2]=new HuluBoy("老三","黄色",3);
        Boys[3]=new HuluBoy("老四","绿色",4);
        Boys[4]=new HuluBoy("老五","青色",5);
        Boys[5]=new HuluBoy("老六","蓝色",6);
        Boys[6]=new HuluBoy("老七","紫色",7);
    }

    void swap(int a,int b){
        if (a <0||a>6||b<0||b>6)return;
        HuluBoy t=Boys[a];
        Boys[a]=Boys[b];
        Boys[b]=t;
    }

    void printExchange(int a,int b){
        if (a <0||a>6||b<0||b>6||a==b)return;
        Boys[a].getname();
        System.out.print(":"+(a+1)+"->"+(b+1)+"  ");
        Boys[b].getname();
        System.out.print(":"+(b+1)+"->"+(a+1)+"  ");
        swap(a,b);
    }

    //随机站队
    void randomQ(){
        Random random=new Random();
        for(int i=0;i<7;i++){
            swap(i,random.nextInt(7));
        }
    }

    void printName(){
        System.out.println("葫芦娃的站队顺序为：");
        for(int i=0;i<7;i++){
            System.out.print(Boys[i].name+" ");
        }
        System.out.println(" ");
    }

    void printColor(){
        System.out.println("葫芦娃的站队顺序为：");
        for(int i=0;i<7;i++){
            System.out.print(Boys[i].color+" ");
        }
        System.out.println(" ");
    }

    void bubbleSort(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(Boys[j].getrank()>Boys[j+1].getrank())printExchange(j,j+1);
            }
        }
        System.out.println(" ");

    }

    int partition(int low,int high){
        int key=Boys[low].rank;
        while(low<high){
            while(Boys[high].rank>=key&&high>low){
                high--;
            }
            printExchange(low,high);
            while(Boys[low].rank<=key&&high>low){
                low++;
            }
            printExchange(low,high);
        }
        return high;
    }


    void quickSort(int low ,int high){
        if(low>=high){
            return ;
        }
        int index=partition(low,high);
        quickSort(low,index-1);
        quickSort(index+1,high);

    }


}
