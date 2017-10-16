import java.util.Random;
public class sevenBrothers{
    Huluwa[] brothers;

    //构造七个葫芦娃
    sevenBrothers()
    {
        brothers=new Huluwa[7];
        for(int i=1;i<8;i++)
        {
            String color="";
            switch(i)
            {
                case 1:{
                    color="红色";
                    break;
                }
                case 2:{
                    color="橙色";
                    break;
                }
                case 3:{
                    color="黄色";
                    break;
                }
                case 4:{
                    color="绿色";
                    break;
                }
                case 5:{
                    color="青色";
                    break;
                }
                case 6:{
                    color="蓝色";
                    break;
                }
                case 7:{
                    color="紫色";
                    break;
                }
            }
            Huluwa wa=new Huluwa(i,color);
            brothers[i-1]=wa;
        }
    }

    //冒泡排序
    void bubbleSort()
    {
        System.out.println("冒泡法排序：");
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6-i;j++)
            {
                if(brothers[j].no>brothers[j+1].no)
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
    void binarySort()
    {
        System.out.println("二分法排序：");
        for (int i = 1; i < 7; i++)
        {
            int left = 0,right = i-1;
            Huluwa temp=brothers[i];
            while (right >= left)
            {
                int middle = (left + right) / 2;
                if (brothers[i].no < brothers[middle].no)
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
    void randomQ()
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
                brothers[number].no = i + 1;
                String color = "";
                switch (i+1) {
                    case 1: {
                        color = "红色";
                        break;
                    }
                    case 2: {
                        color = "橙色";
                        break;
                    }
                    case 3: {
                        color = "黄色";
                        break;
                    }
                    case 4: {
                        color = "绿色";
                        break;
                    }
                    case 5: {
                        color = "青色";
                        break;
                    }
                    case 6: {
                        color = "蓝色";
                        break;
                    }
                    case 7: {
                        color = "紫色";
                        break;
                    }
                }
                brothers[number].color = color;
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

