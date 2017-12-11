package HuluwaFighting;


public class Field {
    public static final int FieldHeight = 40;
    public static final int FieldWidth = 40;

    private Position[][] battleField;
//    private Creature[] Brothers;
//    private Creature Grandfather;
//    private Creature Snake;
//    private Creature Scorpion;
//    private Creature[] SmallGuys;

//    public Field(Huluwa[] brothers, Growups grandfather, Growups snake, Growups scorpion, Growups[] smallguys){
//        setField();
//        this.Brothers = brothers;
//        this.Grandfather = grandfather;
//        this.Snake = snake;
//        this.Scorpion = scorpion;
//        this.SmallGuys = smallguys;
//    }
    public Field(){
        battleField = new FieldPosition[FieldHeight][FieldWidth];
        for(int i=0; i<FieldHeight; i++){
            for(int j=0; j<FieldWidth; j++){
                battleField[i][j] = new FieldPosition(i, j);
            }
        }
    }

    public void clearField(Creature[] creature){
        for(Creature x: creature){
            x.clearPosition();
        }
    }
    public void clearField(Creature creature){
        creature.clearPosition();
    }

    public void shuffle(Creature[] creature){
        java.util.Random rand = new java.util.Random(24);
        for(int index = 0; index<creature.length; index++){
            int toExchange = rand.nextInt(index+1);
           // System.out.println(creature[index].getPosition().getX()+" "+creature[index].getPosition().getY());
            if(creature[index].getPosition()!=null && creature[toExchange].getPosition()!=null) {
                Position temp = creature[index].getPosition();
                creature[index].setPosition(creature[toExchange].getPosition());
                creature[toExchange].setPosition(temp);
            }
           // System.out.println(creature[index].getPosition().getX()+" "+creature[index].getPosition().getY());
        }

    }

    public Position getPosition(int x, int y){return battleField[x][y];}

    public Boolean Deploy(String filename, Creature[] creature){
        DrawField pen = new DrawField();
        Boolean[][] cache = pen.Draw(filename, FieldHeight, FieldWidth);

        assert(cache.length == this.FieldHeight);
        assert(cache[0].length == this.FieldWidth);

        Boolean rtn = true;
        int count = 0;
        for(int row = 0; row<FieldHeight&&count<creature.length; row++){
            for(int col = 0; col<FieldWidth&&count<creature.length; col++){
                if(cache[row][col]){
                    if(battleField[row][col].isOccupied())
                        rtn = false;
                    else
                        creature[count++].setPosition(battleField[row][col]);
                }
            }
        }
        return rtn;
    }

    public Boolean putCreature(int row, int col, Creature creature){
        if(row>=0&&row<=FieldHeight&&col>=0&&col<=FieldWidth){
            if(battleField[row][col].isOccupied())
                return false;
            creature.setPosition(battleField[row][col]);
            return true;
        }
        else
            return false;
    }

    public void displayField(){
        String indexInfo=new String("");
        for(int row=0; row<FieldWidth; row++){
            for(int col=0; col<FieldHeight; col++){
                if(battleField[row][col].isOccupied()) {
                    System.out.printf("0 ");
                    indexInfo += "("+row + "," + col+": "+battleField[row][col].getHolder().getName()+")";
                }
                else
                    System.out.printf("* ");
            }
            System.out.println();
        }

        System.out.print(indexInfo);
    }

    public static void main(String[] args){
        //各路神通初始化：
        Creature[] Brothers = new Huluwa[7];
        Creature[] Enemy = new Growups[100];
        for(int i=0; i<Brothers.length; i++)
            Brothers[i]=new Huluwa(i);
        Enemy[0] = new Growups("蝎子精");
        for(int i=1; i<Enemy.length; i++) {
            Enemy[i] = new Growups("小锣咯");
        }
        Creature Snake = new Growups("蛇精");
        Creature Grandpa = new Growups("爷爷");

        //初始化战场，将葫芦娃长蛇排阵：
        Field field = new Field();
        field.Deploy("resource/长蛇.png", Brothers);
        field.shuffle(Brothers);
        //field.displayField();

        //将葫芦娃排序：
        SortCreature sorter = new SortCreature();
        sorter.Sort(Brothers);
        //field.displayField();


        //放置妖怪，并让爷爷，蛇精在角落里加油：
        field.Deploy("resource/鹤翼.png", Enemy);
        field.putCreature(0,Field.FieldWidth-1,Grandpa);
        field.putCreature(0,0,Snake);
        field.displayField();

        //重新放置妖怪：
        field.clearField(Enemy);
        field.Deploy("resource/锋矢.png", Enemy);
        field.displayField();
    }
}
