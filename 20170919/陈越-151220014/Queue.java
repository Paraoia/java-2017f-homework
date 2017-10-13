package huluwa;

import java.util.Random;

public class Queue {

    private Position positions[];
    private int num;
    Queue(int n)
    {
        num = n;
        positions = new Position[num+1];//第8个位置为空位，用于交换位置
        for(int i=0;i<=num;i++)
            positions[i] = new Position();

    }

    public int getNum() {
        return num;
    }

    public Position[] getPositions() {
        return positions;
    }

    //让葫芦娃一次输出排名
    public void printNum()
    {
        for(int i=0;i<num;i++)
        {
            positions[i].getHolder().printNum();
        }
    }

    //让葫芦娃一次输出颜色
    public void printColor()
    {
        for(int i=0;i<num;i++)
        {
            positions[i].getHolder().printColor();
        }
    }

    //随机生成葫芦娃的初始排序
    public void shuffle()
    {
        Random ran = new Random();
        positions[0].setHolder(new huluwa(ran.nextInt(num)+1));
        int i=1;
        for(;i<num;i++) {
            int j = 0;
            while (j != i) {
                positions[i].setHolder( new huluwa(ran.nextInt(num) + 1));
                for (j = 0; j < i && positions[j].getHolder().cmp(positions[i].getHolder()) != 0; j++) ;
            }
        }
    }

    //交换葫芦娃的位置
    public void swap(int i,int j)
    {
        positions[i].getHolder().sitdown(positions[num],i,num);
        positions[j].getHolder().sitdown(positions[i],j,i);
        positions[num].getHolder().sitdown(positions[j],num,j);

    }

}
