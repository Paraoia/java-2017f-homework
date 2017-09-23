import java.util.Scanner;

public class Huluwa {
    public static void main(String[] args){
        int []rank = new int[7];
        HLW []huluwa = new HLW[7];

        //冒泡排序
        System.out.println("输入葫芦娃的排行\n");
        Scanner input = new Scanner(System.in);
        for(int i=0;i<=6;i++){
            rank[i] = input.nextInt();
            HLW temp =new HLW(rank[i]);
            huluwa[i] = temp;
        }
        BubbleSort sort0 = new BubbleSort();
        sort0.HLWBubbleSort(0,huluwa.length-1,huluwa);
        //报数
        for(int m=0;m<=6;m++) {
            huluwa[m].Talk((m+1)+"");
        }

        //颜色排序（快排）
        System.out.println("输入葫芦娃的颜色(red,orange,yellow,green,blue,indigo,purple)\n");
        for(int i=0;i<=6;i++){
            String temp = input.next();
            huluwa[i] = new HLW(temp);
        }
        QuickSort sort = new QuickSort();
        sort.HLWQuickSort(0,huluwa.length-1,huluwa);
        //报数
        for(int i=0;i<=6;i++){
            huluwa[i].Talk(huluwa[i].GetColor());
        }
}
}

class HLW{
    private int rank; //1-7 表示排行
    private String color; //表示赤橙红绿蓝靛紫

    //初始化
    public HLW(int ranktemp){
        String []COLOR = new String[]{"red","orange","yellow","green","blue","indigo","purple"};
        rank = ranktemp;
        color=COLOR[ranktemp-1];

    }
    public HLW(String colortemp){
        color=colortemp;
        String []COLOR = new String[]{"red","orange","yellow","green","blue","indigo","purple"};
        for(int j=0;j<=6;j++){
            if(colortemp.compareTo(COLOR[j])==0){
                rank=j+1;
                break ;
            }
        }
    }

    //比较两个葫芦娃排行
    public boolean CompareRank(HLW huluwa){
        if(rank >=  huluwa.rank)
            return true;
        else
            return false;
    }

    //得到这个葫芦娃的颜色
    public String GetColor(){
        return color;
    }

    //比较葫芦娃颜色顺序//0等于 1大于 -1小于
    public int CompareColor(HLW huluwa) {
       int i=0;
       String[] COLOR = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "purple"};
       for (;i <= 6; i++) {
           if ((COLOR[i].compareTo(color) == 0) || (COLOR[i].compareTo(huluwa.color) == 0)) {
               break;
           }
       }
       if((COLOR[i].compareTo(color) == 0)&&(COLOR[i].compareTo(huluwa.color) != 0)){
           return 1;
       }
       else if((COLOR[i].compareTo(color) == 0)&&(COLOR[i].compareTo(huluwa.color) == 0)){
           return 0;
       }
       else
           return -1;
   }

   //葫芦娃说话
    public void Talk(String phase){
        switch (rank){
            case 1: System.out.println("老大：" + phase); break;
            case 2: System.out.println("老二：" + phase); break;
            case 3: System.out.println("老三：" + phase); break;
            case 4: System.out.println("老四：" + phase); break;
            case 5: System.out.println("老五：" + phase); break;
            case 6: System.out.println("老六：" + phase); break;
            case 7: System.out.println("老七：" + phase); break;
            default : break;

        }
   }
}

class QuickSort{
    void HLWQuickSort(int low, int high,HLW []huluwa){
        if(low > high)
            return;
        HLW temp = huluwa[low];
        int i=low;
        int j=high;
        while(i!=j){
            while(huluwa[j].CompareColor(temp)<=0&&i<j)
                j--;
            while(huluwa[i].CompareColor(temp)>=0&&i<j)
                i++;
            if(i<j){
                HLW temp1 = huluwa[i];
                huluwa[i]=huluwa[j];
                huluwa[i].Talk((i+1)+"->"+(j+1));
                huluwa[j]=temp1;
                huluwa[j].Talk((j+1)+"->"+(i+1));
            }
        }
        huluwa[low]=huluwa[i];
        if(low!=i)
            huluwa[i].Talk((i+1) + "->" + (low+1));
        huluwa[i]=temp;
        if(i!=low)
            temp.Talk((low+1) + "->" + (i+1));

        HLWQuickSort(low,i-1,huluwa);
        HLWQuickSort(i+1,high,huluwa);
    }
}

class BubbleSort{
    void HLWBubbleSort(int low, int high, HLW[]huluwa){
        for(int m=low;m<high;m++){
            for(int n=m; n<high-m;n++){
                if(huluwa[n].CompareRank(huluwa[n+1])){
                    HLW temp = huluwa[n];
                    huluwa[n].Talk((n+1) + "->" + (n+2));
                    huluwa[n]=huluwa[n+1];
                    huluwa[n+1].Talk((n+2) + "->" + (n+1));
                    huluwa[n+1]=temp;
                }
            }
        }
    }
}