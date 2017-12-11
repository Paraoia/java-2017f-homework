/**
 * Created by Yuyang Wei on 2017/10/10.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Position{
    public int index;
    public HULUWA holder;
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

    public void EnQueue(HULUWA[] members){
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

    private void Swap(int i,int j){
        String name = positions[i].holder.getName();
        COLOR color = positions[i].holder.getColor();
        int order = positions[i].holder.getOrder();

        positions[i].holder.setName(positions[j].holder.getName());
        positions[i].holder.setColor(positions[j].holder.getColor());
        positions[i].holder.setOrder(positions[j].holder.getOrder());

        positions[j].holder.setName(name);
        positions[j].holder.setColor(color);
        positions[j].holder.setOrder(order);
    }

    public void BubbleSort(){
        for(int i = 0;i < positions.length;i++){
            for(int j = i + 1;j < positions.length;j++){
                if(positions[i].holder.getOrder() > positions[j].holder.getOrder()){
                    System.out.println(positions[j].holder.reportOrder() + ":" + (j + 1) + "->" + (i + 1));
                    System.out.println(positions[i].holder.reportOrder() + ":" + (i + 1) + "->" + (j + 1));
                    this.Swap(i,j);
                }
            }
        }
    }

    private int Partition(int low,int high){
        COLOR pivot = positions[low].holder.getColor();
        int start = low;
        while(low < high){
            while(high > low && positions[high].holder.getColor().compareTo(pivot) >= 0)
                high--;

            while(high > low && positions[low].holder.getColor().compareTo(pivot) <= 0)
                low++;

            if(low < high){
                System.out.println(positions[high].holder.reportOrder() + ":" + (high + 1) + "->" + (low + 1));
                System.out.println(positions[low].holder.reportOrder() + ":" + (low + 1) + "->" + (high + 1));
                this.Swap(low,high);
            }
        }
        if(high != start){
            System.out.println(positions[high].holder.reportOrder() + ":" + (high + 1) + "->" + (start + 1));
            System.out.println(positions[start].holder.reportOrder() + ":" + (start + 1) + "->" + (high + 1));
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
            System.out.println(positions[i].holder.reportOrder());
    }

    public void ReportColor(){
        for(int i = 0;i < positions.length;i++)
            System.out.println(positions[i].holder.reportColor());
    }
}
