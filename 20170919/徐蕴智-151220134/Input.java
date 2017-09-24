import java.util.Scanner;
//不检查输入的正确性
public class Input {
    Scanner scanner=new Scanner(System.in);
    String str[]=new String[7];
public     int rank[]=new int[7];
public     HuLuWaColour colour[]=new HuLuWaColour[7];
    int RankOrColor=0;

    Input(){}

    HuLuWaColour GetColor(String str){
        //String str=scanner.nextLine();
        switch (str){
            case "红色":
                return HuLuWaColour.RED;
            case "橙色":
                return HuLuWaColour.ORANGE;
            case "黄色":
                return HuLuWaColour.YELLOW;
            case "绿色":
                return HuLuWaColour.GREEN;
            case "青色":
                return HuLuWaColour.CYAN;
            case "蓝色":
                return HuLuWaColour.BLUE;
            case "紫色":
                return HuLuWaColour.PURPLE;
        }
        return null;
    }

    int GetRank(String str){
        //String str=scanner.nextLine();
        switch (str){
            case "老大":
                return 1;
            case "老二":
                return 2;
            case "老三":
                return 3;
            case "老四":
                return 4;
            case "老五":
                return 5;
            case "老六":
                return 6;
            case "老七":
                return 7;
            default:
                return -1;
        }
    }

    void GetLine(){
        RankOrColor=0;
        String line = scanner.nextLine();
        //System.out.println(line);//
        Scanner s = new Scanner(line);
        int i=0;
        while (s.hasNext()&&i<7){
            str[i++]=s.next();
            //System.out.println(str[i-1]);//
        }
        for(int j=0;j<7;j++){
            if(RankOrColor==0){
                if(GetRank(str[j])==-1) RankOrColor=2;
                else RankOrColor=1;
                j--;
                //System.out.println(RankOrColor);//
            }
            else if(RankOrColor==1){
                rank[j]=GetRank(str[j]);
            }
            else if(RankOrColor==2){
                colour[j]=GetColor(str[j]);
            }
        }
    }
}
