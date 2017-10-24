/**
 * Created by tangruize on 10/16/17.
 */
public class Battle {
    // each position's index is creatures' index.
    private int [][]map;

    // map size, no less than 12
    private final int SIZE = 12;

    /* contains all creatures;
     * 0 for grandpa, 1~7 for calabash brothers, 8 for scorpion king and others for lackeys
     */
    private Creature[] creatures;

    // creatures num
    private final int NUM = 28;

    // init creatures and map, and place grandpa and the scorpion king.
    Battle() {
        // create creatures
        creatures = new Creature[NUM];
        creatures[0] = new Grandpa();
        for (int i = 0; i < 7; ++i) {
            creatures[i + 1] = new CalabashBrother(i);
        }
        creatures[8] = new SnakeQueen();
        creatures[9] = new ScorpionKing();
        for (int i = 10; i < NUM; ++i) {
            creatures[i] = new Lackey();
        }

        // init map
        map = new int[SIZE][];
        for (int i = 0; i < SIZE; ++i) {
            map[i] = new int[SIZE];
            for (int j = 0; j < SIZE; ++j) {
                map[i][j] = -1;
            }
        }

        // grandpa
        map[0][2] = 0;

        // scorpion king
        map[0][8] = 8;
    }

    // print the map
    void print() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (map[i][j] != -1 && map[i][j] < NUM) {
                    System.out.print(creatures[map[i][j]].getAttr());
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }

    // rand sort calabash brothers
    void randCalabashArray() {
        int startLine = 3, startCol = 2;
        int[] indices = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < 7; ++i) {
            int x = (int)(Math.random() * 7);
            int y = (int)(Math.random() * 7);
            int tmp = indices[x];
            indices[x] = indices[y];
            indices[y] = tmp;
        }
        for (int i = startLine; i < startLine + 7; ++i) {
            map[i][startCol] = indices[i - startLine];
        }
    }

    // clear villains area and then place a new array
    private void clearVillainsArea() {
        for (int i = 1; i < SIZE; ++i) {
            for (int j = 4; j < SIZE; ++j) {
                map[i][j] = -1;
            }
        }
    }

    // crane wing array (鹤翼)
    void craneWingArray() {
        clearVillainsArea();
        int startLine = 4, startCol = 5;
        int j = 9; // first lackey index
        for (int i = startLine; i < startLine + 4; ++i) {
            map[i][startCol + i - startLine] = j++;
            map[i][startCol + startLine + 6 - i] = j++;
        }
    }

    // goose fly array (雁行)
    void gooseFlyArray() {
        clearVillainsArea();
        int startLine = 4, startCol = 10;
        int j = 9;
        for (int i = startLine; i < startLine + 5; ++i) {
            map[i][startCol - i + startLine] = j++;
        }
    }

    // Balance yoke array (衡轭)
    void balanceYokeArray() {
        clearVillainsArea();
        int startLine = 3, startCol = 7;
        int j = 9;
        for (int i = startLine; i < startLine + 6; ++i) {
            map[i][startCol + (i - startLine + 1) % 2] = j++;
        }
    }

    // long snake array (长蛇)
    void longSnakeArray() {
        clearVillainsArea();
        int startLine = 3, startCol = 8;
        int j = 9;
        for (int i = startLine; i < startLine + 7; ++i) {
            map[i][startCol] = j++;
        }
    }

    // fish scale array (鱼鳞)
    void fishScaleArray() {
        clearVillainsArea();
        int startLine = 4, startCol = 5;
        int j = 9;
        for (int i = startLine; i < startLine + 4; ++i) {
            for (int k = 0; k < (i - startLine) * 2 + 1; ++k) {
                map[i][startLine + startCol + 3 - i + k] = j++;
            }
        }
        map[startLine + 4][startCol + 2] = map[startLine + 1][startCol + 2];
        map[startLine + 1][startCol + 2] = -1;
        map[startLine + 4][startCol + 3] = map[startLine + 1][startCol + 3];
        map[startLine + 1][startCol + 3] = -1;
    }

    // square round array (方円)
    void squareRoundArray() {
        clearVillainsArea();
        int startLine = 4, startCol = 6;
        int j = 9;
        map[startLine][startCol + 2] = j++;
        for (int i = startLine + 1; i < startLine + 5; ++i) {
            map[i][startCol + Math.abs(i - startLine - 2)] = j++;
            map[i][startCol + 4 - Math.abs(i - startLine - 2)] = j++;
        }
    }

    // lay down half moon array (偃月)
    void layDownHalfMoonArray() {
        clearVillainsArea();
        int startLine = 2, startCol = 6;
        int j = 9;
        for (int i = startLine; i < startLine + 4; ++i) {
            map[i][startCol + startLine + 3 - i] = j++;
            map[i + 1][startCol + startLine + 3 - i] = j++;
        }
        for (int i = startLine + 4; i < startLine + 8; ++i) {
            map[i][startCol + i - startLine - 4] = j++;
            map[i + 1][startCol + i - startLine - 4] = j++;
        }
        map[startLine + 4][startCol + 1] = j;
    }

    // sharp array array (锋矢)
    void sharpArrayArray() {
        clearVillainsArea();
        int startLine = 3, startCol = 5;
        int j = 9;
        map[startLine][startCol + 3] = j++;
        for (int i = startLine + 1; i < startLine + 4; ++i) {
            map[i][startCol + i - startLine + 3] = j++;
            map[i][startCol + startLine + 3 - i] = j++;
        }
        for (int i = startLine + 1; i < startLine + 7; ++i) {
            map[i][startCol + 3] = j++;
        }
    }
}
