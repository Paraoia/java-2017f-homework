public class huluwa {
    int name;
    int color;
    int rank;
    int getname(){
        return name;
    }
    int getcolor(){
        return color;
    }
    int getrank(){
        return rank;
    }
    void sayname(){
        switch(name){
            case 1:System.out.printf("老大 ");break;
            case 2:System.out.printf("老二 ");break;
            case 3:System.out.printf("老三 ");break;
            case 4:System.out.printf("老四 ");break;
            case 5:System.out.printf("老五 ");break;
            case 6:System.out.printf("老六 ");break;
            case 7:System.out.printf("老七 ");
        }
    }
    void saycolor(){
        switch(color){
            case 1:System.out.println("红色");break;
            case 2:System.out.println("橙色");break;
            case 3:System.out.println("黄色");break;
            case 4:System.out.println("绿色");break;
            case 5:System.out.println("青色");break;
            case 6:System.out.println("蓝色");break;
            case 7:System.out.println("紫色");
        }
    }
    void MoveTo(int i){
        sayname();
        System.out.printf(": %d -> %d\n",rank,i);
        rank = i;
    }
    void huluwa(){
        name = -1;
        color = -1;
        rank = -1;
    }
    void huluwa(int i, int j){
        name = i;
        color = j;
        rank = -1;
    }
    void huluwa(int i, int j,int k){
        name = i;
        color = j;
        rank = k;
    }

    void set(int i, int j,int k){
        name = i;
        color = j;
        rank = k;
    }

    void setrank(int i){
        rank = i;
    }

}
