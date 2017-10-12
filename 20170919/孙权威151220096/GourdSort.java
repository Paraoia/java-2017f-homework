public class GourdSort {
    public Gourd[] Gourds;
    public void initial(){
        Gourds=new Gourd[7];
        Gourd first=new Gourd(1,3,"老大","红色");
        Gourd second=new Gourd(2,4,"老二","橙色");
        Gourd third=new Gourd(3,7,"老三","黄色");
        Gourd forth=new Gourd(4,5,"老四","绿色");
        Gourd fifth=new Gourd(5,2,"老五","青色");
        Gourd sixth=new Gourd(6,1,"老六","蓝色");
        Gourd seventh=new Gourd(7,6,"老七","紫色");
        Gourds[0]=sixth;
        Gourds[1]=fifth;
        Gourds[2]=first;
        Gourds[3]=second;
        Gourds[4]=forth;
        Gourds[5]=seventh;
        Gourds[6]=third;
    }
    public GourdSort(){
        initial();
    }
    void BubbleGourdSort(){
        for(int i=0;i<7;i++){
            for(int j=0;j<6-i;j++){
                //位置在前的辈分小了,age大了
                if(Gourds[j].age>Gourds[j+1].age){
                    Gourd temp;
                    temp=Gourds[j];
                    Gourds[j]=Gourds[j+1];
                    Gourds[j+1]=temp;
                    Gourds[j].ChangePosition(j);
                    Gourds[j+1].ChangePosition(j+1);
                }
            }
        }
    }
    //这里记得实现快速排序
    void Sort(Gourd dolls[],int low,int high){
        int start=low;int end=high;
        Gourd index=dolls[low];
        while(start<end){
            while(start<end && dolls[end].age>index.age)
                end--;
            if(dolls[end].age<=index.age){
                Gourd temp=dolls[end];
                dolls[end]=dolls[start];
                dolls[start]=temp;
            }
            while(start<end && dolls[start].age<index.age)
                start++;
            if(dolls[start].age>index.age){
                Gourd temp=dolls[start];
                dolls[start]=dolls[end];
                dolls[end]=temp;
            }
        }
        if(start>low)
            Sort(dolls,low,start-1);
        if(end<high)
            Sort(dolls,end+1,high);
    }
    void QuickSort(){
        Sort(Gourds,0,6);
    }

    void CoutName(){
        for(int i=0;i<7;i++){
            System.out.print(Gourds[i].name+" ");
        }
        System.out.print('\n');
    }
    void CoutColor(){
        for(int i=0;i<7;i++) {
            System.out.print(Gourds[i].color + " ");
        }
    }
    public static void main(String[] args){
        GourdSort Dolls=new GourdSort();
        Dolls.BubbleGourdSort();
        Dolls.CoutName();
        Dolls.initial();
        Dolls.QuickSort();
        Dolls.CoutColor();
    }
}
