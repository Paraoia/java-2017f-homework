import javafx.geometry.Pos;

import java.util.ArrayList;

public class StrategySelector<T extends Creature> {
    private int row;
    ArrayList<Position<Creature>> pos;

    StrategySelector(int inRow, ArrayList<Position<Creature>> inPos) {
        row = inRow;
        pos = inPos;
    }
    
    /*The strategy can only be used by huluwas.*/
    public void changeShe(ArrayList<T> creatures) {
        creatures.get(7).setPosition(pos.get(row - 1));
        int len = creatures.size() - 1;
        int start = (row - len) / 2;
        for (int i = 1; i <= len; i++) {
            creatures.get(i - 1).setPosition(pos.get(start + i - 1));
        }
    }

    public void heYi(ArrayList<T> creatures) {
        if (creatures.size() < 8) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow));
        for (int i = leadRow + 1; i < leadRow + 4; i++) {
            creatures.get(beg++).setPosition(pos.get(i * row + leadRow + leadRow - i));
            creatures.get(beg++).setPosition(pos.get(i * row + i));
        }
    }

    public void yanXing(ArrayList<T> creatures) {
        if (creatures.size() < 6) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        for (int i = 0; i < 5; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow + 2 - i));
        }
    }

    public void hengE(ArrayList<T> creatures) {
        if (creatures.size() < 7) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        for (int i = 0; i < 3; i++) {
            creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow + 2 - i * 2));
        }
        leadRow++;
        for (int i = 0; i < 3; i++) {
            creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow + 2 - i * 2));
        }
    }

    public void yuLin(ArrayList<T> creatures) {
        if (creatures.size() < 12) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow));
        creatures.get(beg++).setPosition(pos.get((leadRow + 1) * row + leadRow + 1));
        for (int i = 0; i < 3; i++)
            creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + leadRow - 1 + i));
        for (int i = 0; i < 5; i++)
            creatures.get(beg++).setPosition(pos.get((leadRow + 3) * row + leadRow - 2 + i));
        creatures.get(beg).setPosition(pos.get((leadRow + 4) * row + leadRow));
    }

    public void fangDou(ArrayList<T> creatures) {
        if (creatures.size() < 9) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow));
        for (int i = 1; i < 4; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow - 2 + Math.abs(i - 2)));
            creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow + 2 - Math.abs(i - 2)));
        }
        creatures.get(beg).setPosition(pos.get((leadRow + 4) * row + leadRow));
    }

    public void yanYue(ArrayList<T> creatures) {
        if (creatures.size() < 20) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow - 1));
        creatures.get(beg++).setPosition(pos.get(leadRow * row + leadRow + 1));
        for (int i = 0; i < 5; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + 1) * row + leadRow - 2 + i));
        }
        for (int i = 0; i < 7; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + leadRow - 3 + i));
        }
        for (int i = 0; i < 2; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + i + 3) * row + leadRow - 3 - i));
            creatures.get(beg++).setPosition(pos.get((leadRow + i + 3) * row + leadRow + 3 + i));
        }
    }

    public void fengShi(ArrayList<T> creatures) {
        if (creatures.size() < 13) return;
        int leadRow = row / 2 - ((row % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures.get(beg++).setPosition(pos.get((leadRow + 2) * row + row - 1));
        for (int i = 0; i < 6; i++) {
            creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow));
            if (i > 0 && i < 4) {
                creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow - i));
                creatures.get(beg++).setPosition(pos.get((leadRow + i) * row + leadRow + i));
            }
        }
    }
}
