public class Space {
    static int spaceSize=0;
    static MARK [][]space;
    static TYPE [][]type;
    //只允许创造一个空间
    static Space CreateSpace(int size){
        if(s==null)
            s=new Space(size);
        return s;
    }

    //输出空间
    public void print(){
        for (int i=0;i<spaceSize;i++) {
            for (int j = 0; j < spaceSize; j++){
                if(space[i][j]==MARK.空)
                    System.out.print("  ");
                else
                    System.out.print(space[i][j]);
            }
            System.out.println();
        }
    }

    private static Space s = null;
    private Space(int size) {
        spaceSize = size;
        space = new MARK[spaceSize][spaceSize];
        type = new TYPE[spaceSize][spaceSize];
        for (int i = 0; i < spaceSize; i++)
            for (int j = 0; j < spaceSize; j++) {
                space[i][j] = MARK.空;
                type[i][j] = TYPE.未知;
            }
    }
}

enum MARK{
    红, 橙, 黄, 绿, 蓝, 青, 紫 ,蝎, 喽, 蛇, 爷, 未, 空
}