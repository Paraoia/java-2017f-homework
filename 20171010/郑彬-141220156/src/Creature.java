/**
 * Created by bingo on 2017/10/22.
 */

public class Creature {
    // Each creature has an id, it generates automatically when constructed.
    private int _id;
    private static int cnt = 0;

    Creature() {
        this._id = cnt;
        cnt ++;
    }

    public void report() {
        System.out.println(this.toString());
    }

    public String getName() { return new String("生物"); }

    public char getSymb() {
        return 'X';
    }

    public String toString() {
        return "ID: " + String.valueOf(this._id);
    }
}
