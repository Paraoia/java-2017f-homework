public class StrategySelector {

    /*The strategy can only be used by huluwas.*/
    public void changeShe(Creature[] creatures, Position[][] pos) {
        creatures[0].setPosition(pos[0][pos.length - 1]);
        int len = creatures.length - 1;
        int start = (pos.length - len) / 2;
        for (int i = 1; i <= len; i++) {
            creatures[i].setPosition(pos[0][start + i - 1]);
        }
    }

    public void heYi(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 8) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        creatures[beg++].setPosition(pos[leadRow][leadRow]);
        for (int i = leadRow + 1; i < leadRow + 4; i++) {
            creatures[beg++].setPosition(pos[i][leadRow + leadRow - i]);
            creatures[beg++].setPosition(pos[i][i]);
        }
    }

    public void yanXing(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 6) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        for (int i = 0; i < 5; i++) {
            creatures[beg++].setPosition(pos[leadRow + i][leadRow + 2 - i]);
        }
    }

    public void hengE(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 7) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        for (int i = 0; i < 3; i++) {
            creatures[beg++].setPosition(pos[leadRow][leadRow + 2 - i * 2]);
        }
        leadRow++;
        for (int i = 0; i < 3; i++) {
            creatures[beg++].setPosition(pos[leadRow][leadRow + 2 - i * 2]);
        }
    }

    public void yuLin(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 12) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        creatures[beg++].setPosition(pos[leadRow][leadRow]);
        creatures[beg++].setPosition(pos[leadRow + 1][leadRow + 1]);
        for (int i = 0; i < 3; i++)
            creatures[beg++].setPosition(pos[leadRow + 2][leadRow - 1 + i]);
        for (int i = 0; i < 5; i++)
            creatures[beg++].setPosition(pos[leadRow + 3][leadRow - 2 + i]);
        creatures[beg].setPosition(pos[leadRow + 4][leadRow]);
    }

    public void fangDou(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 9) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        creatures[beg++].setPosition(pos[leadRow][leadRow]);
        for (int i = 1; i < 4; i++) {
            creatures[beg++].setPosition(pos[leadRow + i][leadRow - 2 + Math.abs(i - 2)]);
            creatures[beg++].setPosition(pos[leadRow + i][leadRow + 2 - Math.abs(i - 2)]);
        }
        creatures[beg].setPosition(pos[leadRow + 4][leadRow]);
    }

    public void yanYue(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 20) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        creatures[beg++].setPosition(pos[leadRow][leadRow]);
        creatures[beg++].setPosition(pos[leadRow][leadRow - 1]);
        creatures[beg++].setPosition(pos[leadRow][leadRow + 1]);
        for (int i = 0; i < 5; i++) {
            creatures[beg++].setPosition(pos[leadRow + 1][leadRow - 2 + i]);
        }
        for (int i = 0; i < 7; i++) {
            creatures[beg++].setPosition(pos[leadRow + 2][leadRow - 3 + i]);
        }
        for (int i = 0; i < 2; i++) {
            creatures[beg++].setPosition(pos[leadRow + i + 3][leadRow - 3 - i]);
            creatures[beg++].setPosition(pos[leadRow + i + 3][leadRow + 3 + i]);
        }
    }

    public void fengShi(Creature[] creatures, Position[][] pos) {
        if (creatures.length < 13) return;
        int leadRow = pos.length / 2 - ((pos.length % 2 == 0) ? 1 : 0);
        int beg = 0;
        creatures[beg++].setPosition(pos[leadRow + 2][pos.length - 1]);
        for (int i = 0; i < 6; i++) {
            creatures[beg++].setPosition(pos[leadRow + i][leadRow]);
            if (i > 0 && i < 4) {
                creatures[beg++].setPosition(pos[leadRow + i][leadRow - i]);
                creatures[beg++].setPosition(pos[leadRow + i][leadRow + i]);
            }
        }
    }
}
