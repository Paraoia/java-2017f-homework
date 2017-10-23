/**
 * Created by admin on 2017/10/17.
 */

enum formation_ {
    鹤翼,雁行,衡轭,长蛇,鱼鳞,方圆,偃月,锋矢
}

public class Formation {
    private formation_ kind;
    private Creature[] creatures;
    private int[][] position;

    Formation(formation_ kind,Creature[] creatures) {
        this.kind = kind;
        this.creatures = creatures;
        switch(kind) {
            case 鹤翼:
                position = new int[Situation.N][Situation.N];
                position[4][Situation.N-8] = 1;
                position[5][Situation.N-7] = 1;
                position[6][Situation.N-6] = 1;
                position[7][Situation.N-5] = 1;
                position[6][Situation.N-4] = 1;
                position[5][Situation.N-3] = 1;
                position[4][Situation.N-2] = 1;
                break;
            case 雁行:
                position = new int[Situation.N][Situation.N];
                position[7][Situation.N-7] = 1;
                position[6][Situation.N-6] = 1;
                position[5][Situation.N-5] = 1;
                position[4][Situation.N-4] = 1;
                position[3][Situation.N-3] = 1;
                break;
            case 衡轭:
                position = new int[Situation.N][Situation.N];
                position[4][Situation.N-4] = 1;
                position[5][Situation.N-5] = 1;
                position[6][Situation.N-4] = 1;
                position[7][Situation.N-5] = 1;
                position[8][Situation.N-4] = 1;
                position[9][Situation.N-5] = 1;
                break;
            case 长蛇:
                position = new int[Situation.N][Situation.N];
                position[3][2] = 2;
                position[4][2] = 2;
                position[5][2] = 2;
                position[6][2] = 2;
                position[7][2] = 2;
                position[8][2] = 2;
                position[9][2] = 2;
                break;
            case 鱼鳞:
                position = new int[Situation.N][Situation.N];
                position[7][Situation.N-8] = 1;
                position[6][Situation.N-7] = 1;
                position[7][Situation.N-6] = 1;
                position[8][Situation.N-5] = 1;
                position[6][Situation.N-5] = 1;
                position[4][Situation.N-5] = 1;
                position[7][Situation.N-4] = 1;
                position[5][Situation.N-4] = 1;
                position[6][Situation.N-3] = 1;
                position[7][Situation.N-2] = 1;
                break;
            case 方圆:
                position = new int[Situation.N][Situation.N];
                position[6][Situation.N-8] = 1;
                position[5][Situation.N-7] = 1;
                position[7][Situation.N-7] = 1;
                position[4][Situation.N-6] = 1;
                position[8][Situation.N-6] = 1;
                position[5][Situation.N-5] = 1;
                position[7][Situation.N-5] = 1;
                position[6][Situation.N-4] = 1;
                break;
            case 偃月:
                position = new int[Situation.N][Situation.N];
                position[4][Situation.N-8] = 1;
                position[5][Situation.N-8] = 1;
                position[6][Situation.N-8] = 1;
                position[4][Situation.N-7] = 1;
                position[5][Situation.N-7] = 1;
                position[6][Situation.N-7] = 1;
                position[3][Situation.N-6] = 1;
                position[7][Situation.N-6] = 1;
                position[2][Situation.N-5] = 1;
                position[4][Situation.N-5] = 1;
                position[5][Situation.N-5] = 1;
                position[6][Situation.N-5] = 1;
                position[8][Situation.N-5] = 1;
                position[3][Situation.N-4] = 1;
                position[7][Situation.N-4] = 1;
                position[2][Situation.N-3] = 1;
                position[8][Situation.N-3] = 1;
                position[1][Situation.N-2] = 1;
                position[9][Situation.N-2] = 1;
                break;
            case 锋矢:
                position = new int[Situation.N][Situation.N];
                position[2][Situation.N-5] = 1;
                position[3][Situation.N-6] = 1;
                position[3][Situation.N-4] = 1;
                position[4][Situation.N-5] = 1;
                position[4][Situation.N-3] = 1;
                position[4][Situation.N-7] = 1;
                position[5][Situation.N-5] = 1;
                position[5][Situation.N-2] = 1;
                position[5][Situation.N-8] = 1;
                position[6][Situation.N-5] = 1;
                position[7][Situation.N-5] = 1;
                position[8][Situation.N-5] = 1;
                break;
            default:break;
        }
    }

    public int[][] getPosition() {
        return position;
    }
}
