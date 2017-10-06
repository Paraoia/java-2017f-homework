public class Queue {
    private HuLuWa[] Q;
    private int length;
    Queue(int n){
        Q=new HuLuWa[n];
        length=n;
    }
    public void Initial_Queue(int seed){
        switch (seed){
            case 1:
                Q[1]=new HuLuWa(3);
                Q[2]=new HuLuWa(2);
                Q[3]=new HuLuWa(7);
                Q[4]=new HuLuWa(4);
                Q[5]=new HuLuWa(6);
                Q[6]=new HuLuWa(1);
                Q[7]=new HuLuWa(5);

                break;
            case 2:
                Q[1]=new HuLuWa(6);
                Q[2]=new HuLuWa(3);
                Q[3]=new HuLuWa(4);
                Q[4]=new HuLuWa(7);
                Q[5]=new HuLuWa(1);
                Q[6]=new HuLuWa(5);
                Q[7]=new HuLuWa(2);
                break;
        }
    }
    public int Get_Rank(int a){
        return Q[a].Return_Rank();
    }
    public void Hop(int a,int b){
        ///
        int temp=Q[a].Return_Rank();
        Q[a].Set_Rank(Q[b].Return_Rank());
        Q[b].Set_Rank(temp);
        Honk(Q[b].Return_Rank());
        System.out.println(":"+a+" -> "+b);
    }
    public void Honk(int a){
        switch (a){
            case 1:System.out.print("老大 ");break;
            case 2:System.out.print("老二 ");break;
            case 3:System.out.print("老三 ");break;
            case 4:System.out.print("老四 ");break;
            case 5:System.out.print("老五 ");break;
            case 6:System.out.print("老六 ");break;
            case 7:System.out.print("老七 ");break;
        }
    }

    public static void main(String[] args){
        Queue Myqueue=new Queue(8);
        Myqueue.Initial_Queue(1);
        //Bubble_Sort
        for (int i=1;i<=7;i++){
            for (int j=i;j<=7;j++){
                if (Myqueue.Get_Rank(i)>Myqueue.Get_Rank(j))
                    Myqueue.Hop(i,j);
            }
        }
        for(int i=1;i<=7;i++)
            Myqueue.Honk(Myqueue.Get_Rank(i));
        System.out.println();
        //
        Myqueue.Initial_Queue(2);
        //Quick_sort
        for (int i=1;i<=7;i++){
            int temp=i;
            boolean changed=false;
            for(int j=temp;j<=7;j++)
                if(Myqueue.Get_Rank(j)<Myqueue.Get_Rank(temp))
                {temp=j;changed=true;}
            if(changed)
                Myqueue.Hop(temp,i);
        }
        for(int i=1;i<=7;i++)
            Myqueue.Honk(Myqueue.Get_Rank(i));
        System.out.println();
        //
    }
}