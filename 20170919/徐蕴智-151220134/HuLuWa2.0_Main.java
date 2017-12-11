public class Main {

    public static void main(String[] args) {
        //从前有个老爷爷
        Grandfather grandpapa=new Grandfather();
        //老爷爷种出七个葫芦娃
        grandpapa.Seed();
        //老爷爷找来7张凳子，让葫芦娃们随机入座
        grandpapa.TakeSeats();
        //老爷爷指挥葫芦娃们冒泡排序
        grandpapa.BubbleSort();
        grandpapa.SayOutName();
        //再次随机入座
        grandpapa.TakeSeats();
        //老爷爷指挥葫芦娃们快速排序
        grandpapa.QuickSort(0,6);
        grandpapa.SayOutColor();
    }
}

class Grandfather{
    private HuLuWa[] seven_huluwas;
    private Queue queue;
    void Seed(){
        seven_huluwas=new HuLuWa[7];
        for(int i=0;i<7;i++){
            seven_huluwas[i]=new HuLuWa(i+1);
        }
    }
    void TakeSeats(){//第二次随机入座的时候可以直接调用这个方法吗？
        /*TODO*/
        queue=new Queue(seven_huluwas,7);
    }
    //爷爷让葫芦娃报数
    void SayOutName(){
        for(int i=0;i<7;i++){
            queue.seats[i].seater.SayName();
            System.out.print(" ");
            //queue.seats[i].seater.SayColor();
        }
        System.out.print("\n");
    }
    void SayOutColor(){
        for(int i=0;i<7;i++){
            //queue.seats[i].seater.SayName();
            queue.seats[i].seater.SayColor();
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    //爷爷指挥葫芦娃们排序
    void BubbleSort(){
        for (int i= 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (queue.seats[i].seater.Seniority() > queue.seats[j].seater.Seniority()) {
                    queue.seats[i].seater.SayMovement(i,j);
                    queue.seats[j].seater.SayMovement(j,i);
                    queue.Swap(i,j);
                }
            }
        }
    }
    void QuickSort(int l,int r){
        if(l>=r)return;
        int last = r;
        int first =l;
        HuLuWa key =queue.seats[l].seater;
        while(first<last)
        {
            while(queue.seats[last].seater.Seniority()>key.Seniority()&&first<last)
            {
                last--;
            }
            queue.seats[last].seater.SayMovement(last,first);
            queue.Move(last,first);//rank[first]=rank[last];
            while(key.Seniority()>queue.seats[first].seater.Seniority()&&first<last)
            {
                first++;
            }
            queue.seats[last].seater.SayMovement(last,first);
            queue.Move(last,first);//rank[last]=rank[first];
        }
        queue.seats[first].seater=key;
        QuickSort(l,first-1);
        QuickSort(first+1,r);
    }
}
