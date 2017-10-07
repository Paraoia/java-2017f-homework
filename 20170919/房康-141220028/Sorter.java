import java.util.Comparator;
import java.util.List;

public class Sorter {

    public Sorter(){}

    public void bubbleSort(List<Person> list, Comparator<Person> comparator){
        int size = list.size();
        for(int i=0;i<size;++i){
            for(int j=i;j<size;++j){
                if(comparator.compare(list.get(i), list.get(j))>0){
                    swap(list,i,j);
                }
            }
        }
    }

    public void quickSort(List<Person> list, Comparator<Person> comparator){
        sort(list,0, list.size()-1, comparator);
    }

    private void sort(List<Person> list, int low ,int high, Comparator<Person> comparator){
        if(low < high){
            int pos = partition(list, low, high, comparator);
            sort(list, low, pos-1, comparator);
            sort(list, pos+1, high, comparator);
        }
    }

    private int partition(List<Person> list, int low, int high, Comparator<Person> comparator){
        Person temp = list.get(low);
        int i = low, j = high;
        while(i != j){
            while(comparator.compare(list.get(j), temp)>=0 && i<j){
                j--;
            }
            while(comparator.compare(list.get(i), temp)<=0 && i<j){
                i++;
            }
            if(i < j){
                swap(list, i, j );
            }
        }
        list.set(low,list.get(i));
        list.set(i, temp);
        return i;
    }

    private void swap(List<Person> list, int i, int j){
        Person t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
        System.out.println("brother " + list.get(i).getOrder().name() +" :" + i + "->" + j);
        System.out.println("brother " + list.get(j).getOrder().name() +" :" + j + "->" + i);
    }
}
