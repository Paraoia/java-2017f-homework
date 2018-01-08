public class CucurbitBrother {
    int rank;
    String color;
    int NumHeye;
    CucurbitBrother(int r)
    {
        rank=r;
        switch (r)
        {
            case 0:color="chi";break;
            case 1:color="cheng";break;
            case 2:color="huang";break;
            case 3:color="lv";break;
            case 4:color="qing";break;
            case 5:color="lan";break;
            case 6:color="zi";break;
        }
        NumHeye=-1;
    }

    int getRank(){return rank;}
    String getColor(){return color;}
    int getNumHeye(){return NumHeye;}

    void jump(int r){NumHeye=r;}
    void SpeakYourName(){
        switch (rank)
        {
            case 0:System.out.print("老大");break;
            case 1:System.out.print("老二");break;
            case 2:System.out.print("老三");break;
            case 3:System.out.print("老四");break;
            case 4:System.out.print("老五");break;
            case 5:System.out.print("老六");break;
            case 6:System.out.print("老七");break;
        }
    }

    void SpeakYourColor(){
        switch (rank)
        {
            case 0:System.out.print("红色");break;
            case 1:System.out.print("橙色");break;
            case 2:System.out.print("黄色");break;
            case 3:System.out.print("绿色");break;
            case 4:System.out.print("青色");break;
            case 5:System.out.print("蓝色");break;
            case 6:System.out.print("紫色");break;
        }
    }
}
