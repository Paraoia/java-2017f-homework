public class Output {
    Output(){}

    void Change(int rank,int src,int des){
        String str=null;
        switch (rank){
            case 1:
                str="老大";
                break;
            case 2:
                str="老二";
                break;
            case 3:
                str="老三";
                break;
            case 4:
                str="老四";
                break;
            case 5:
                str="老五";
                break;
            case 6:
                str="老六";
                break;
            case 7:
                str="老七";
                break;
        }
        if(src!=des)System.out.println("\""+str+":"+src+"->"+des+"\"");
    }

    void  PrintRank(int rank){
        switch (rank){
            case 1:
                System.out.print("老大");
                break;
            case 2:
                System.out.print("老二");
                break;
            case 3:
                System.out.print("老三");
                break;
            case 4:
                System.out.print("老四");
                break;
            case 5:
                System.out.print("老五");
                break;
            case 6:
                System.out.print("老六");
                break;
            case 7:
                System.out.print("老七");
                break;
        }
        System.out.print(" ");
    }

    void PrintRank(int rank[],int n){
        for(int i=0;i<n;i++) {
            PrintRank(rank[i]);
        }
    }

    void PrintColor(HuLuWaColour colour){
        switch (colour){
            case RED:
                System.out.print("红色");
                break;
            case ORANGE:
                System.out.print("橙色");
                break;
            case YELLOW:
                System.out.print("黄色");
                break;
            case GREEN:
                System.out.print("绿色");
                break;
            case CYAN:
                System.out.print("青色");
                break;
            case BLUE:
                System.out.print("蓝色");
                break;
            case PURPLE:
                System.out.print("紫色");
                break;
        }
    System.out.print(" ");
    }

    void Print(HuLuWa huluwa[],int n,int RankOrColor){
        //Rank
        if(RankOrColor==1){
            for(int i=0;i<n;i++){
                PrintRank(huluwa[i].Rank);
            }
        }
        //Color
        else if(RankOrColor==2){
            for(int i=0;i<n;i++){
                PrintColor(huluwa[i].Color);
            }
        }
        System.out.print("\n");
    }
}
