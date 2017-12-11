import java.util.Random;
public class sevenBrothers{
    private Huluwa[] brothers;

    //构造七个葫芦娃
    public sevenBrothers()
    {
        brothers=new Huluwa[7];
        for(int i=1;i<8;i++)
        {
            Color color=Color.RED;
            switch(i)
            {
                case 1:{
                    color=Color.RED;
                    break;
                }
                case 2:{
                    color=Color.ORANGE;
                    break;
                }
                case 3:{
                    color=Color.YELLOW;
                    break;
                }
                case 4:{
                    color=Color.GREEN;
                    break;
                }
                case 5:{
                    color=Color.CYAN;
                    break;
                }
                case 6:{
                    color=Color.BLUE;
                    break;
                }
                case 7:{
                    color=Color.PURPLE;
                    break;
                }
            }
            Huluwa wa=new Huluwa(i,color);
            brothers[i-1]=wa;
        }
    }

    //冒泡排序
    public void bubbleSort()
    {
        System.out.println("冒泡法排序：");
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6-i;j++)
            {
                if(brothers[j].getNo()>brothers[j+1].getNo())
                {
                    brothers[j].numberOff();
                    Huluwa temp=brothers[j];
                    brothers[j]=brothers[j+1];
                    brothers[j+1]=temp;
                    System.out.println(":"+j+"->"+(j+1));
                }
            }
        }
        for(int i=0;i<7;i++)
        {
            brothers[i].numberOff();
            System.out.print(" ");
        }
        System.out.println();
    }

    //二分法排序
    public void binarySort()
    {
        System.out.println("二分法排序：");
        for (int i = 1; i < 7; i++)
        {
            int left = 0,right = i-1;
            Huluwa temp=brothers[i];
            while (right >= left)
            {
                int middle = (left + right) / 2;
                if (brothers[i].getNo() < brothers[middle].getNo())
                    right = middle - 1;
                else
                    left = middle + 1;
            }

            for (int j = i - 1; j >= left; j--)
            {
                brothers[j+1]=brothers[j];
                brothers[j+1].numberOff();
                System.out.println(":" + j + "->" + (j+1));
            }


            brothers[left] = temp;
            if(left!=i)
            {
                brothers[left].numberOff();
                System.out.println(":" + i + "->" + left);
            }
        }
        for(int i=0;i<7;i++)
        {
            brothers[i].colorOff();
            System.out.print(" ");
        }
        System.out.println();
    }

    //随机排队
    public void randomQ()
    {
        Random r = new Random();
        boolean bool[]={false,false,false,false,false,false,false};
        for(int i=0;i<7;)
        {
            int number = r.nextInt(7);
            if(bool[number]==true)//已经占了
                continue;
            else {
                bool[number] = true;
                int no = i + 1;
                Color color =Color.RED;
                switch (i+1) {
                    case 1: {
                        color = Color.RED;
                        break;
                    }
                    case 2: {
                        color = Color.ORANGE;
                        break;
                    }
                    case 3: {
                        color = Color.YELLOW;
                        break;
                    }
                    case 4: {
                        color = Color.GREEN;
                        break;
                    }
                    case 5: {
                        color = Color.CYAN;
                        break;
                    }
                    case 6: {
                        color = Color.BLUE;
                        break;
                    }
                    case 7: {
                        color = Color.PURPLE;
                        break;
                    }
                }
                Huluwa temp=new Huluwa(no,color);
                brothers[number]=temp;
                i++;
            }
        }
        System.out.print("初始排队序列：");
        for(int i=0;i<7;i++)
        {
            brothers[i].numberOff();
            System.out.print(" ");
        }
        System.out.println();
    }
};

