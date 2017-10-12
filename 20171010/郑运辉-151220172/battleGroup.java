public class battleGroup{
    //构造函数
    public battleGroup(TYPE Type,int Size){
        size=Size;
        type=Type;
        switch (type){
            case 葫芦兄弟:
                group=new Huluwa[size];
                for(int i=0;i<size;i++){
                    group[i]=new Huluwa(0,0,COLOR.values()[i]);
                }
                ChangShe(1,1);
                break;

            case 坏人:
                group=new Enemy[size];
                for(int i=0;i<size;i++){
                    if(i!=size/2)
                        group[i]=new Enemy(0,0,ENEMYTYPE.喽啰);
                    else
                        group[i]=new Enemy(0,0,ENEMYTYPE.蝎子精);
                }
                ChangShe(1,7);
                break;

            default:System.out.println("Error when form battleGroup in Normal");
        }
    }

    public battleGroup(TYPE Type,int Size,int[] Ran){
        size=Size;
        type=Type;
        switch (Type){
            case 葫芦兄弟:
                group=new Huluwa[size];
                for(int i=0;i<size;i++){
                    group[i]=new Huluwa(0,0,COLOR.values()[Ran[i]]);
                }
                ChangShe(1,1);
                break;

            case 坏人:
                group=new Enemy[size];
                for(int i=0;i<size;i++){
                    if(i!=Ran[0])
                        group[i]=new Enemy(0,0,ENEMYTYPE.喽啰);
                    else
                        group[i]=new Enemy(0,0,ENEMYTYPE.蝎子精);
                }
                ChangShe(1,7);
                break;
            default:System.out.println("Error when form battleGroup in Random");
        }
    }

    //长蛇阵
    public boolean ChangShe(int row,int col){
        if(row+ size > Space.spaceSize || col >Space.spaceSize || row <0|| col<0){
            System.out.println("Please check the validity");
            return false;
        }

        for(int i=0;i<size;i++) {
            if (Space.space[row+i][col] != MARK.空
                    && Space.type[row+i][col] !=group[i].type) {
                System.out.println("设置" + group[i].type + "位置为(" + (row+i)%10 + "," + col%10 + ")时非法");
                return false;
            }
        }

        System.out.println(group[0].type+"变成了长蛇阵");
        for(int i=0;i<size;i++) {
            if(Space.space[group[i].getRow()][group[i].getCol()]==group[i].mark
                    && Space.type[group[i].getRow()][group[i].getCol()]==group[i].type)
                Space.space[group[i].getRow()][group[i].getCol()]=MARK.空;
            group[i].setRow(row + i);
            group[i].setCol(col);
            Space.space[group[i].getRow()][group[i].getCol()]=group[i].mark;
            Space.type[group[i].getRow()][group[i].getCol()]=group[i].type;
        }
        return true;
    }

    //冲轭阵
    public boolean ChongE(int row,int col){
        if(row+ size > Space.spaceSize || col >Space.spaceSize || row <0|| col<1){
            System.out.println("Please check the validity");
            return false;
        }

        for(int i=0;i<size;i++) {
            if (Space.space[row+i][col+i%2] != MARK.空
                    && Space.type[row+i][col+i%2] !=group[i].type ) {
                System.out.println("设置" + group[i].type + "位置为(" + (row+i)%10 + "," + (col+i%2)%10 + ")时非法");
                return false;
            }
        }

        System.out.println(group[0].type+"变成了冲轭阵");
        for(int i=0;i<size;i++) {
            if(Space.space[group[i].getRow()][group[i].getCol()] == group[i].mark
                    && Space.type[group[i].getRow()][group[i].getCol()] == group[i].type)
                Space.space[group[i].getRow()][group[i].getCol()]=MARK.空;
            group[i].setPosition(row + i,col+i%2);
            Space.space[group[i].getRow()][group[i].getCol()]=group[i].mark;
            Space.type[group[i].getRow()][group[i].getCol()]=group[i].type;
        }
        return true;
    }

    Soldier []group;
    int size;
    TYPE type;
}
