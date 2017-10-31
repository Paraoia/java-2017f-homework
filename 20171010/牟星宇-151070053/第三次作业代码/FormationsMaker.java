public interface FormationsMaker {

    /*  武田八阵  */
    //长蛇阵
    public void LongSnake(Space space, Creature[] creatures, int row, int col);

    //锋矢阵
    public  void Arrow(Space space, Creature[] creatures, int row, int col);

    //鹤翼阵
    public void Crane(Space space, Creature[] creatures, int row, int col);

    //雁形阵
    public void Goose(Space space, Creature[] creatures, int row, int col);

    //冲轭阵
    public void ChongE(Space space, Creature[] creatures, int row, int col);

    //鱼鳞阵
    public void Scale(Space space, Creature[] creatures, int row, int col);

    //方圆阵
    public void FangY(Space space, Creature[] creatures, int row, int col);

    //偃月阵
    public void Moon(Space space, Creature[] creatures, int row, int col);

}
