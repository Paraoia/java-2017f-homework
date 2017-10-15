import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Position{
    public int index;
    public Calabash holder;
}

public class Queue {
    private Position[] positions;

    public Queue(){
        positions = new Position[7];
        for(int i = 0;i < positions.length;i++){
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }

    public void EnQueue(Calabash[] members){
        if(members.length > this.positions.length)
            return;

        List list = new ArrayList();
        Integer[] array = new Integer[members.length];

        for(int i = 0;i < members.length;i++)
            list.add(i);
        Collections.shuffle(list);
        list.toArray(array);
        for(int i = 0;i < members.length;i++)
            positions[i].holder = members[array[i]];
    }

    /*public void Display(){
        for(int i = 0;i < positions.length;i++)
            System.out.println(positions[i].holder.GetOrder() + " " + positions[i].holder.GetColor());
    }*/

    private void Swap(int i,int j){
        String name = positions[i].holder.GetName();
        COLOR color = positions[i].holder.GetColor();
        int order = positions[i].holder.GetOrder();

        positions[i].holder.SetName(positions[j].holder.GetName());
        positions[i].holder.SetColor(positions[j].holder.GetColor());
        positions[i].holder.SetOrder(positions[j].holder.GetOrder());

        positions[j].holder.SetName(name);
        positions[j].holder.SetColor(color);
        positions[j].holder.SetOrder(order);
    }
    public void BubbleSort(){
        for(int i = 0;i < positions.length;i++){
            for(int j = i + 1;j < positions.length;j++){
                if(positions[i].holder.GetOrder() > positions[j].holder.GetOrder()){
                    System.out.println(positions[j].holder.ReportOrder() + ":" + (j + 1) + "->" + (i + 1));
                    System.out.println(positions[i].holder.ReportOrder() + ":" + (i + 1) + "->" + (j + 1));
                    this.Swap(i,j);
                }
            }
        }
    }

    private int Partition(int low,int high){
        COLOR pivot = positions[low].holder.GetColor();
        int start = low;
        while(low < high){
            while(high > low && positions[high].holder.GetColor().compareTo(pivot) >= 0)
                high--;

            while(high > low && positions[low].holder.GetColor().compareTo(pivot) <= 0)
                low++;

            if(low < high){
                System.out.println(positions[high].holder.ReportOrder() + ":" + (high + 1) + "->" + (low + 1));
                System.out.println(positions[low].holder.ReportOrder() + ":" + (low + 1) + "->" + (high + 1));
                this.Swap(low,high);
            }
        }
        if(high != start){
            System.out.println(positions[high].holder.ReportOrder() + ":" + (high + 1) + "->" + (start + 1));
            System.out.println(positions[start].holder.ReportOrder() + ":" + (start + 1) + "->" + (high + 1));
            this.Swap(start,high);
        }
        return high;
    }

    public void QuickSort(int low,int high){
        if(low >= high)
            return;
        int index = this.Partition(low,high);
        QuickSort(low,index - 1);
        QuickSort(index + 1,high);
    }

    public void ReportOrder(){
        for(int i = 0;i < positions.length;i++)
            System.out.println(positions[i].holder.ReportOrder());
    }
    public void ReportColor(){
        for(int i = 0;i < positions.length;i++)
            System.out.println(positions[i].holder.ReportColor());
    }
}
