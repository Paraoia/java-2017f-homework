public class Creature {
    public Creature(int row,int col){
        if(Space.space[row][col]!=MARK.空){
            System.out.println("创建"+mark+"为("+row+","+col+")非法");
        }
        Row=row;
        Col=col;
        type=TYPE.未知;
        mark=MARK.未;
    }

    public TYPE getType(){
        return type;
    }

    public MARK getMark(){
        return mark;
    }

    public boolean setPosition(int row,int col){
        if(Space.space[row][col]!=MARK.空
                && Space.type[row][col] != type){
            System.out.println("设置"+mark+"为("+row+","+col+")非法");
            return false;
        }
        Row=row;
        Col=col;
        return true;
    }
    public int [] getPosition(){
        int []temp=new int[2];
        temp[0]=Row;
        temp[1]=Col;
        return temp;
    }

    public boolean setRow(int row){
        if(Space.space[row][getCol()]!=MARK.空){
            System.out.println("设置"+mark+"为("+row+","+getCol()+")非法");
            return false;
        }
        Row=row;
        return true;
    }
    public int getRow(){
        return Row;
    }

    public boolean setCol(int col){
        if(Space.space[getRow()][col]!=MARK.空){
            System.out.println("设置"+mark+"为("+getRow()+","+col+")非法");
            return false;
        }
        Col=col;
        return true;
    }
    public int getCol(){
        return Col;
    }

    public boolean setOnSpace(){
        if(Space.space[getRow()][getCol()]!=MARK.空){
            System.out.println("将"+mark+"放置在("+getRow()+","+getCol()+")时非法");
            return false;
        }
        Space.space[getRow()][getCol()]=mark;
        return true;
    }

    protected int Row;
    protected int Col;
    protected TYPE type;
    protected MARK mark;

}

enum TYPE{
    葫芦兄弟, 坏人, 爷爷, 蛇精,未知
}

