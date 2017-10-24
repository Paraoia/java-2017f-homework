import java.util.*;
public class HuluBrothers {

    private Huluwa[] hulubrothers;
    private int HuluwaNum;

    //构造函数
    HuluBrothers(){
        this.HuluwaNum = 7;
        this.hulubrothers = new Huluwa[HuluwaNum];
        this.hulubrothers[0]=new Huluwa(1);
        this.hulubrothers[1]=new Huluwa(4);
        this.hulubrothers[2]=new Huluwa(3);
        this.hulubrothers[3]=new Huluwa(5);
        this.hulubrothers[4]=new Huluwa(2);
        this.hulubrothers[5]=new Huluwa(7);
        this.hulubrothers[6]=new Huluwa(6);
    }

    //葫芦娃顺序交换
    void ChangePosition(int i , int j){
        Huluwa hulutemp = new Huluwa(this.hulubrothers[i].getRank());
        this.hulubrothers[i]=this.hulubrothers[j];
        this.hulubrothers[j].HuluwaTalk(this.hulubrothers[j].getRankString() + " : "+(j+1) + "->" + (i+1));
        this.hulubrothers[j]=hulutemp;
        this.hulubrothers[i].HuluwaTalk(this.hulubrothers[i].getRankString()+ " : "+(i+1) + "->" + (j+1));
    }

    //冒泡排序
    void UseBubbleSort(){
        for(int i=0;i<this.HuluwaNum-1;i++){
            for(int j=0;j<this.HuluwaNum-1-i;j++){
                if(this.hulubrothers[j].CompareRank(this.hulubrothers[j+1]))
                    this.ChangePosition(j,j+1);
            }
        }
    }

    //快速排序
    void UseQuickSort(){
        this.QuickSort(0,this.HuluwaNum-1);
    }


    void QuickSort(int low, int high ){

        if(low > high)
            return;

        Huluwa temp = this.hulubrothers[low];
        int i=low;
        int j=high;

        while(i!=j){
            while(this.hulubrothers[j].CompareColor(temp)&&i<j)
                j--;
            while(!this.hulubrothers[i].CompareColor(temp)&&i<j)
                i++;
            if(i<j){
                this.ChangePosition(i,j);
            }
        }
        if(i!=low)
            this.ChangePosition(low,i);

        QuickSort(low,i-1);
        QuickSort(i+1,high);
    }

    //报数
    void TellNumber(){
        for(int i=0;i<=this.HuluwaNum-1;i++)
            this.hulubrothers[i].HuluwaTalk(this.hulubrothers[i].getRankString()+ " : "+ String.format("%s",this.hulubrothers[i].getRank()));
    }

    //报颜色
    void TellColor(){
        for(int i=0; i<=this.HuluwaNum-1;i++)
            this.hulubrothers[i].HuluwaTalk(this.hulubrothers[i].getRankString()+" : "+this.hulubrothers[i].getColorString());
    }
}
