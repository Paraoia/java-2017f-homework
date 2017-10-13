package Huluwa;

class Chair{
    HuLuWa holder;
}

public class Queue {
    Chair []chair;//chair[7] is temp to exchange

    void initQueue(HuLuWa []huluwa){
        chair=new Chair[8];
        for(int i=0;i<8;i++){
            chair[i]=new Chair();
        }
        chair[0].holder=huluwa[3];
        chair[1].holder=huluwa[6];
        chair[2].holder=huluwa[1];
        chair[3].holder=huluwa[0];
        chair[4].holder=huluwa[2];
        chair[5].holder=huluwa[5];
        chair[6].holder=huluwa[4];
    }

    public void reportName(){//按顺序报名字
        for(int i=0;i<7;i++){
            System.out.print(chair[i].holder.rtnName()+' ');
        }
        System.out.println();
    }
    public void reportColor(){//按顺序报颜色
        for(int i=0;i<7;i++){
            String tmp=new String("null");
            switch(chair[i].holder.rtnColor()){
                case RED:
                    tmp="红色";
                    break;
                case ORANGE:
                    tmp="橙色";
                    break;
                case YELLOW:
                    tmp="黄色";
                    break;
                case GREEN:
                    tmp="绿色";
                    break;
                case CHING:
                    tmp="青色";
                    break;
                case BLUE:
                    tmp="蓝色";
                    break;
                case PURPLE:
                    tmp="紫色";
                    break;
            }
            System.out.print(tmp+' ');
        }
        System.out.println();
    }

    void exchangeChair(int from,int to){
        chair[from].holder.tellMove(from, to);
        chair[to]=chair[from];
    }
    //按排位冒泡排序
    public void bubbleSort(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7-i-1;j++){
                if(chair[j+1].holder.rtnRank()<chair[j].holder.rtnRank()){
                    exchangeChair(j,7);
                    exchangeChair(j+1,j);
                    exchangeChair(7,j+1);
                }
            }
        }
    }
    //按颜色快速排序
    public  void quickSort(int left ,int right){
        if(left<right){
            int i=left;
            int j=right;
            String name_tmp=chair[left].holder.rtnName();
            chair[7]=chair[left];
            int key=chair[left].holder.rtnColor().ordinal();
            while(i<j){
                while(i<j && chair[j].holder.rtnColor().ordinal()>key)
                    j--;
                if(i<j){

                    exchangeChair(j,i);
                    i++;
                }
                while(i<j && chair[i].holder.rtnColor().ordinal()<key)
                    i++;
                if(i<j){
                    exchangeChair(i,j);
                    j--;
                }

            }
            System.out.println(name_tmp+":"+"->"+String.valueOf(i));
            chair[i]=chair[7];
            quickSort(left,i-1);
            quickSort(i+1,right);
        }
    }

}

