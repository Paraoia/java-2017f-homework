public class Line {
    CalabashBox line[] = new CalabashBox[8]; //line[0]不用

    Line() {
        for(int i = 1; i <= 7; i ++) {
            CalabashBox b = new CalabashBox();
            line[i] = b;
        }
    }
    Line(Line l) {
        for(int i = 1; i <= 7; i ++) {
            line[i] = new CalabashBox(l.line[i]);
        }
    }

    boolean sit(int id, int position) {
        if(line[position].empty) {
            line[position].empty = false;
            line[position].id = id;
            return true;
        }
        else {
            return false;
        }
    }
    void leave(int position) {
        line[position].empty = true;
    }
    void dicing() {
        for(int i = 1; i <= 7; i ++)
            line[i].empty = true;
    }
    int id_at(int pos) {
        if(pos < 1 || pos > 7 || line[pos].empty)
            return -1;
        else
            return line[pos].id;
    }
    boolean empty_at(int pos) {
        return line[pos].empty;
    }
    void show_line() {
        for(int i = 1; i <= 7; i ++){
            if(!line[i].empty)
                System.out.print(line[i].id+" ");
            else
                System.out.print("- ");
        }
        System.out.println();
    }
}
