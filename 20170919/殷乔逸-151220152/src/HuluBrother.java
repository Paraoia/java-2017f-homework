enum Color {
    CHI, CHENG, HONG, LV, QING, LAN, ZI;
}

public class HuluBrother {
    int num;
    Color clr;
    String name=new String();

    void setName(String name){
        this.name=name;
    }

    void setClr(Color clr){
        this.clr=clr;
    }

    void setNum(int num){
        this.num=num;
    }

    String getName(){
        return this.name;
    }

    void move(MyQueue myqueue, int pos){
        System.out.println(myqueue.position[pos].holder.name + ":" +(pos+1)+"->"+(pos+2));
        System.out.println(myqueue.position[pos+1].holder.name + ":" +(pos+2)+"->"+(pos+1));
        HuluBrother temp=myqueue.position[pos+1].holder;
        myqueue.position[pos+1].holder=myqueue.position[pos].holder;
        myqueue.position[pos].holder=temp;
    }

    void swap(MyQueue myqueue, int pos, int splitpt){
        if (pos==splitpt)
            return;

        System.out.println(myqueue.position[pos].holder.name+":"+(pos+1)+"->"+(splitpt+1));
        System.out.println(myqueue.position[splitpt].holder.name+":"+(splitpt+1)+"->"+(pos+1));

        HuluBrother temp=myqueue.position[splitpt].holder;
        myqueue.position[splitpt].holder=myqueue.position[pos].holder;
        myqueue.position[pos].holder=temp;
    }
}
