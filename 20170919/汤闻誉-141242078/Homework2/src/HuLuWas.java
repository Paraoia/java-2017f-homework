import java.util.Random;
public class HuLuWas {
    HuLuWa array[];

    HuLuWas(){
        array=new HuLuWa[7];
        array[0]=new HuLuWa("老大","红色",1);
        array[1]=new HuLuWa("老二","橙色",2);
        array[2]=new HuLuWa("老三","黄色",3);
        array[3]=new HuLuWa("老四","绿色",4);
        array[4]=new HuLuWa("老五","青色",5);
        array[5]=new HuLuWa("老六","蓝色",6);
        array[6]=new HuLuWa("老七","紫色",7);
    }

    void swap(Integer x,Integer y){
        if(x<0||y<0||x>6||y>6)return;
        HuLuWa temp=array[x];
        array[x]=array[y];
        array[y]=temp;
    }

    void lineup(){
        Random r=new Random();
        for(Integer i=0;i<7;i++)swap(i,r.nextInt(7));
    }

    void printLineByName(){
        System.out.println("当前的站队顺序为：");
        for(Integer i=0;i<7;i++)array[i].tellName();
        System.out.println("");
    }

    void printLineByColor(){
        System.out.println("当前的站队顺序为：");
        for(Integer i=0;i<7;i++)array[i].tellColor();
        System.out.println("");
    }

    void exchange(int x,int y){
        if(x==y)return;
        if(x<0||y<0||x>6||y>6){
            System.out.println("There is a bug");
            return;
        }
        array[x].reportMovement(x+1,y+1);
    //    System.out.print(": "+(x+1)+"->"+(y+1)+"   ");

        array[y].reportMovement(y+1,x+1);
    //   System.out.print(": "+(y+1)+"->"+(x+1)+"\n");
        swap(x,y);
    }

    void bubbleSort(){
        for(Integer i=0;i<6;i++){
            for(Integer j=0;j<6-i;j++){
                if(array[j].getValue()>array[j+1].getValue())exchange(j,j+1);
            }
        }
    }

    void quickSort(Integer p,Integer r){
        if(p>=r)return;
        Integer q=partition(p,r);
        quickSort(p,q-1);
        quickSort(q+1,r);
    }

    Integer partition(Integer p,Integer r){
        Integer x=array[r].getValue();
        Integer i=p-1;
        for(Integer j=p;j<r;j++){
            if(array[j].getValue()<x){
                i++;
                exchange(i,j);
            }
        }
        exchange(i+1,r);
        return i+1;
    }

}



