import java.util.Random;

public class HuluSort {
    private Position[] positions;
    private Creature[] creatures;

    public static void main(String[] args) {

        //生成葫芦娃兄弟
        Huluwa[] bros = new Huluwa[7];
        for (int i=0;i<bros.length;i++){
            bros[i] = new Huluwa(Huluwa.COLOUR.values()[i], Huluwa.SENIORITY.values()[i]);
        }

        //生成队列
        HuluSort Line = new HuluSort(bros);
        Sorter lineSort = new Sorter();
        Line.allReport();

        Line.shuffle1();
        Line.allReport();
        lineSort.bubbleSort(Line);
        Line.allReport();
        Line.shuffle1();
        Line.allReport();
        lineSort.binaryInsertSort(Line);
        Line.allReport();
        
    }

    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    public HuluSort(Huluwa[] bros) {
        this.positions = new Position[bros.length];
        this.creatures = bros;

        for(int i=0;i<bros.length;i++){
            this.positions[i]= new Position(i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }

    public void bubbleSort(){
        System.out.println("冒泡排序过程！");
        for (int i=0;i<this.positions.length-1;i++){
            for (int j=0;j<this.positions.length-1-i;j++){
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j+1].getHolder()))){
                    Creature temp = this.positions[j].getHolder();
                    this.positions[j+1].getHolder().setPosition(positions[j]);
                    temp.setPosition(positions[j+1]);
                }
            }
        }
        System.out.println();
    }

    /*public void binaryInsertSort(){
        System.out.println("\n二分插入排序过程！");
        Creature temp;
        int i=1;
        int j;
        while ( i < positions.length){
            temp = this.boxes[i];
            int left = 0;
            int right = i-1;
            while (left<=right){
                int mid = (left+right)/2;
                if (temp.getBoxcode()<this.boxes[mid].getBoxcode())
                    right=mid-1;
                else
                    left=mid+1;
            }
            for (j=i-1;j>=left;j--){
                this.boxes[j+1]=this.boxes[j];
            }
            this.boxes[left]=temp;
            System.out.print(temp.readName()+":"+ i +"->"+left+ ", ");
            i++;
        }
        System.out.println();

    }*/

    /*public Creature[] shuffle(){//暂时没有找到shuffle的正确使用方法，故不使用
        System.out.println("\n打乱顺序");
        List list = new ArrayList<Creature>();
        for (int i=0;i<this.creatures.length;i++) {
            list.add(this.creatures[i]);
        }
        Collections.shuffle(list);
        list.toArray(this.creatures);
        return this.creatures;
    }*/

    private void shuffle1() {
        System.out.println("打乱顺序");
        Random random = new Random();
        for (int i=creatures.length-1;i>0;i--) {
            int ranIndex = random.nextInt(i+1);
            Position nPosition = creatures[ranIndex].getPosition();
            creatures[ranIndex].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(nPosition);
        }
    }

    public void allReport(){
        System.out.println("按位置报数");
        for (Position position : this.positions) {

            position.getHolder().report();
        }
        System.out.println("\n");
        System.out.flush();
    }

}

