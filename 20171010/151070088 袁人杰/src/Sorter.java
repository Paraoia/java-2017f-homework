public class Sorter {//Works
    public void bubbleSort(Queue queue){
        System.out.println("冒泡排序过程！");

        for (int i=0;i<7;i++){
            for (int j=0;j<7-1-i;j++){
                if (((Comparation) (queue.getGrid(j).getHolder())).biggerThan((Comparation) (queue.getGrid(j+1).getHolder()))){
                    Creature temp = queue.getGrid(j).getHolder();
                    queue.getGrid(j).setHolder(queue.getGrid(j+1).getHolder());
                    queue.getGrid(j+1).setHolder(temp);
                }
            }
        }
        System.out.println();
    }

    /*public void bubbleSort(Huluwa[] something){
        System.out.println("冒泡排序过程！");
        Grid[] ngrid = new Grid[something.length];
        for (int i= 0;i<something.length;i++){
            ngrid[i]=something[i].getGrid();
            ngrid[i].setHolder(something[i]);
        }
        for (int i= 0;i<something.length;i++){
            for (int j=0;j<something.length-1-i;j++){
                if (((Comparation) (ngrid[j].getHolder())).biggerThan((Comparation) (ngrid[j+1].getHolder()))){
                    Creature temp = ngrid[j].getHolder();
                    ngrid[j].setHolder(ngrid[j+1].getHolder());
                    ngrid[j+1].setHolder(temp);
                }
            }
        }

    }*/

    public void binaryInsertSort(Grid[] line){
        System.out.println("二分插入排序过程！");
        Creature temp = null;
        int i=1;
        int j;
        while ( i < 7){
            temp = line[i].getHolder();
            int left = 0;
            int right = i-1;
            while (left<=right){
                int mid = (left+right)/2;
                if ( ! (((Comparation) temp).biggerThan((Comparation) line[mid].getHolder())))//temp.getBoxcode()<positions[mid].getHolder())
                    right=mid-1;
                else
                    left=mid+1;
            }
            for (j=i;j>=left+1;j--){
                line[j-1].getHolder().setGrid(line[j]);
                //this.boxes[j+1]=this.boxes[j];
            }
            temp.setGrid(line[left]);
            //this.boxes[left]=temp;
            i++;
        }
        System.out.println();

    }
}
