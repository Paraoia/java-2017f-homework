public class Sorter {
    public void bubbleSort(HuluSort line){
        System.out.println("冒泡排序过程！");
        Position[] positions = line.getPositions();
        for (int i=0;i<positions.length-1;i++){
            for (int j=0;j<positions.length-1-i;j++){
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j+1].getHolder()))){
                    Creature temp = positions[j].getHolder();
                    positions[j+1].getHolder().setPosition(positions[j]);
                    temp.setPosition(positions[j+1]);
                }
            }
        }
        System.out.println();
    }

    public void binaryInsertSort(HuluSort line){
        System.out.println("二分插入排序过程！");
        Creature temp = null;
        Position[] positions = line.getPositions();
        int i=1;
        int j;
        while ( i < positions.length){
            temp = positions[i].getHolder();
            int left = 0;
            int right = i-1;
            while (left<=right){
                int mid = (left+right)/2;
                if ( ! (((Comparable) temp).biggerThan((Comparable) positions[mid].getHolder())))//temp.getBoxcode()<positions[mid].getHolder())
                    right=mid-1;
                else
                    left=mid+1;
            }
            for (j=i;j>=left+1;j--){
                positions[j-1].getHolder().setPosition(positions[j]);
                //this.boxes[j+1]=this.boxes[j];
            }
            temp.setPosition(positions[left]);
            //this.boxes[left]=temp;
            i++;
        }
        System.out.println();

    }
}
