public final class SpaceController implements FormationsMaker{

    /*  武田八阵  */
    //长蛇阵
    @Override
    public void LongSnake(Space space, Creature[] creatures, int row, int col){
            space.EnterRow(creatures, row , col);
    }

    //锋矢阵
    @Override
    public void Arrow(Space space, Creature[] creatures, int row, int col){
        int i;
        int halflen = creatures.length / 2;
        for(i = 0; i <= halflen; i++){
            space.EnterCreature(creatures[i], row, col + i - 1);
        }
        for(int j = 0;i < creatures.length - halflen / 2; i++, j++){
            space.EnterCreature(creatures[i], row + j + 1, col + j);
        }
        for(int j = 0;i < creatures.length; i++, j++){
            space.EnterCreature(creatures[i], row - j - 1, col + j);
        }

    }

    //鹤翼阵
    @Override
    public void Crane(Space space, Creature[] creatures, int row, int col){
        int halflen = creatures.length / 2;
        int i;
        for(i = 0; i <= halflen; i++){
            space.EnterCreature(creatures[i], row + i, col + i);
        }
        for(int j = 1; i < creatures.length; j++, i++){
            space.EnterCreature(creatures[i], row - j, col + j);
        }

    }

    //雁形阵
    @Override
    public void Goose(Space space, Creature[] creatures, int row, int col){
        int halflen = creatures.length / 2;
        int i;
        for(i = 0; i <= halflen; i++){
            space.EnterCreature(creatures[i], row + i, col + i);
        }
        for(int j = 1; i < creatures.length; j++, i++){
            space.EnterCreature(creatures[i], row - j, col - j);
        }
    }

    //冲轭阵
    public void ChongE(Space space, Creature[] creatures, int row, int col){
        for(int i = 0; i < creatures.length; i++){
            if(i % 2 == 0){
                space.EnterCreature(creatures[i], row - 1, col + i);
            }
            else {
                space.EnterCreature(creatures[i], row + 1, col + i);
            }
        }
    }

    //鱼鳞阵
    @Override
    public void Scale(Space space, Creature[] creatures, int row, int col){
        int times = (int)Math.sqrt(creatures.length);
        space.EnterCreature(creatures[0], row, col);
        int i = 1;
        for(int j = 1; j < times; j++){
            for(int k = 0; k < 2 * (j + 1) - 1; k++, i++){
                space.EnterCreature(creatures[i], row - j + k, col + j);
            }
        }
        int halflen = (creatures.length - i - 1) / 2;
        for(int j = 0; j <= halflen; j++, i++){
            space.EnterCreature(creatures[i], row + j, col + times + j);
        }
        for(int j = 1; i < creatures.length; j++, i++){
            space.EnterCreature(creatures[i], row - j, col + times + j);
        }

    }

    //方圆阵
    @Override
    public void FangY(Space space, Creature[] creatures, int row, int col){
        int side = creatures.length / 4;
        int i, j, k;
        for(i = 0, j = 0; j < side; i++, j++){
            space.EnterCreature(creatures[i], row + j, col + j);
        }
        for(k = j; j > 0; j--, k++, i++){
            space.EnterCreature(creatures[i], row + j, col + k);
        }
        for(; j < side; j++, k--, i++){
            space.EnterCreature(creatures[i], row - j, col + k);
        }
        for(; j > 0; j--, k--, i++){
            space.EnterCreature(creatures[i], row - j, col + k);
        }
        for(j = side * 2 + 1; i < creatures.length; i++, j++){
            space.EnterCreature(creatures[i], row, col + j);
        }
    }

    //偃月阵
    @Override
    public void Moon(Space space, Creature[] creatures, int row, int col){
        int times = (int)Math.sqrt(creatures.length);
        space.EnterCreature(creatures[0], row, col);
        space.EnterCreature(creatures[1], row - 1, col);
        space.EnterCreature(creatures[2], row + 1, col);
        int i = 3;
        for(int j = 2; j < times; j++){
            for(int k = 0; k < 2 * (j + 1) - 1; k++, i++){
                space.EnterCreature(creatures[i], row - j + k, col + j - 1);
            }
        }
        for(int j = 0; i < creatures.length; i++, j++){
            if(i % 2 == 0){
                space.EnterCreature(creatures[i], row - times - j, col + times + j - 1);
            }
            else
                j--;
                space.EnterCreature(creatures[i], row + times + j, col + times + j - 1);

        }
    }
}
