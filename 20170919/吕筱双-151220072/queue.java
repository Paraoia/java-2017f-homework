
public class queue {

    private position[] positions;

    public position[] getPositions() {
        return positions;
    }

    public void setPositions(int index){
        positions = new position[index];
        for(int i = 0 ; i < index;i++){
            positions[i] = new position();
        }
    }

    public void sitDown(calabash []brothers){
        if(brothers.length > positions.length){
            System.err.println("too many calabash brothers");
        }

        for(int i = 0;i < brothers.length;i++){
            positions[i].setHolder(brothers[i]);
        }

    }

    public void numOff(){
        for(int i = 0 ; i < positions.length && positions[i].getHolder() != null;i++)
            positions[i].getHolder().printName();
    }

    public  void colorOff(){
        for(int i = 0 ; i < positions.length && positions[i].getHolder() != null;i++)
            positions[i].getHolder().printColor();
    }

    public void bubbleSort(){
        for(int i =0; i < positions.length-1 && positions[i].getHolder()!= null;i++){
            for(int j = 0 ; j < positions.length-1-i;j++){
                if(positions[j].getHolder().getName().getIndex() > positions[j+1].getHolder().getName().getIndex())
                {
                    System.out.println(positions[j].getHolder().getName().getName() +':'+(j+1)+"->"+(j+2));
                    System.out.println(positions[j+1].getHolder().getName().getName() +':'+(j+2)+"->"+(j+1));

                    position temp = new position();
                    positions[j].getHolder().move(temp);
                    positions[j+1].getHolder().move(positions[j]);
                    temp.getHolder().move(positions[j+1]);

                }
            }
        }
    }
    /*
    快速排序
     */
    public void quickSort(int low,int high){
        if(low < high){
            int middle = this.getMiddle(low,high);
            this.quickSort(low,middle-1);
            this.quickSort(middle+1,high);
        }
    }
    private int getMiddle(int low,int high){
        position temp = new position();
        positions[low].getHolder().move(temp);
        int flag = low+1;

        while(low < high)
        {
            while(low < high && positions[high].getHolder().getColor().getIndex() >= temp.getHolder().getColor().getIndex())
                high--;

           if(positions[low].getHolder() != positions[high].getHolder())
                System.out.println(positions[high].getHolder().getName().getName() +':'+(high+1)+"->"+(low+1));
            positions[high].getHolder().move(positions[low]);

            while(low < high && positions[low].getHolder().getColor().getIndex() <= temp.getHolder().getColor().getIndex())
                low++;

            if(positions[low].getHolder() != positions[high].getHolder())
                System.out.println(positions[low].getHolder().getName().getName() +':'+(low+1)+"->"+(high+1));
            positions[low].getHolder().move(positions[high]);

        }

        if(positions[low].getHolder() != temp.getHolder())
            System.out.println(temp.getHolder().getName().getName() +':'+flag+"->"+(low+1));
        temp.getHolder().move(positions[low]);

        return low;
    }

}