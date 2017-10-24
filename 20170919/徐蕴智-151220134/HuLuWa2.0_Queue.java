public class Queue {
    //一列有七张凳子
    public Seat[] seats;

    public Queue(HuLuWa[] huluwas,int n){
        //摆好七张凳子，让七个葫芦娃随机坐
        seats=new Seat[n];
        seats[0]=new Seat(0);seats[0].seater=huluwas[6];
        seats[1]=new Seat(1);seats[1].seater=huluwas[5];
        seats[2]=new Seat(2);seats[2].seater=huluwas[4];
        seats[3]=new Seat(3);seats[3].seater=huluwas[3];
        seats[4]=new Seat(4);seats[4].seater=huluwas[2];
        seats[5]=new Seat(5);seats[5].seater=huluwas[1];
        seats[6]=new Seat(6);seats[6].seater=huluwas[0];
    }

    public void Swap(int src,int des) {
        HuLuWa tmp=seats[des].seater;
        seats[des].seater = seats[src].seater;
        seats[src].seater=tmp;
    }

    public void Move(int src,int des){
        //目的凳子的葫芦娃起来把位置让给源凳子的葫芦娃，源凳子上没有葫芦娃就坐
        seats[des].seater=seats[src].seater;
        //seats[src].seater=null;
    }
}

class Seat{
    //每张凳子都有一个编号
    private int No;
    //每张凳子坐一个葫芦娃
    public HuLuWa seater;

    Seat(int index){
        No=index;
    }
}