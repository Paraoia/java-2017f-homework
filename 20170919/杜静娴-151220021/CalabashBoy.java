import java.util.Random;

public class CalabashBoy {

    enum Color{
        RED,
        ORANGE,
        YELLO,
        GREEN,
        CYAN,
        BLUE,
        PURPLE
    };

    String Name[] = {"老大","老二","老三","老四","老五","老六","老七"};


    int ID;
    String name;
    Color color;
    int position;
    int last_position;
    static int count = 7;

    CalabashBoy(){
        if(count == 0)
            System.out.println("There're only 7 Huluwa.");
        else{
            count --;
            ID = 7-count;
            name = new String(Name[ID-1]);
            color = Color.values()[ID-1];
        }
    }



    void move2(int pos) {
        if(pos != position) {
            last_position = position;
            position = pos;
            report();
        }
    }

    private void report() {
        if(last_position != 0)
            System.out.println(name+"："+last_position+"->"+position);
    }

    int take_rand_position(Line line) {
        boolean sit = false;
        int pos = 0;
        Random random = new Random();
        while(!sit) {
            pos = random.nextInt(7)%7+1;
            sit = line.sit(ID, pos);
        }
        move2(pos);
        return pos;
    }

    void report_name() {
        System.out.print(name+" ");
    }
    void report_color() {
        System.out.print(color+" ");
    }
}

class CalabashBox {
    boolean empty = false;
    int id;

    CalabashBox() {
        empty = true;
    }

    CalabashBox(CalabashBox b) {
        empty = b.empty;
        if(!empty)
            id = b.id;
    }
}