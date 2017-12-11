public class EnemyFormation {
    private Position[][] positions;
    private Scorpion scorpion;
    private Minion[] minions;
    private Formation formation;
    private static final int N = 20;

    public EnemyFormation(Scorpion scorpion, Minion[] minions) {
        this.scorpion = scorpion;
        this.minions = minions;
        positions = new Position[N][N];
        for(int i = 0; i < N; i++)
            positions[i] = new Position[N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                positions[i][j] = new Position(i, j);
        }
    }

    public void formate(Formation formation) {
        this.formation = formation;
        int indexOfMinion = 0;
        switch (formation) {
            case 鹤立:
                for (int i = 0; i < 5; i++) {
                    int j = 0;
                    for (j = 0; j < i; j++);
                     //   System.out.print("  ");
                    minions[indexOfMinion++].setPosition(positions[i][j++]);
                    j += 9 - 2*i;
                    minions[indexOfMinion++].setPosition(positions[i][j]);
                }
                scorpion.setPosition(positions[5][5]);
                break;
            case 雁行:
                break;
            case 冲轭:
                break;
            case 长蛇:
                break;
            case 鱼鳞:
                break;
            case 方门:
                break;
            case 偃月:
                break;
            case 锋矢:
                scorpion.setPosition(positions[4][3]);
                for(int i = 0; i < 4; i++)
                    minions[indexOfMinion++].setPosition(positions[i][3]);
                for(int i = 1; i <= 3; i++){
                    int j = 0;
                    for(; j < i - 1; j++)
                        System.out.print("  ");
                    minions[indexOfMinion++].setPosition(positions[i][j++]);
                    j = 7-j;
                    minions[indexOfMinion++].setPosition(positions[i][j]);
                    System.out.println("");
                }
                break;
        }
    }

    public Creature[] getCreature() {
        Creature[] creatures = new Creature[minions.length + 1];
        creatures[0] = scorpion;
        for(int i = 1; i < creatures.length; i++)
            creatures[i] = minions[i-1];
        return creatures;
    }
}
