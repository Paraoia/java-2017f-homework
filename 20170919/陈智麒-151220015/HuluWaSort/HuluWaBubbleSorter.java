package HuluWaSort;

import java.util.ArrayList;

public class HuluWaBubbleSorter extends HuluWaGeneralSorter {

    HuluWaBubbleSorter(ArrayList<HuluWa> huluWaList) {
        super(huluWaList);
    }

    @Override
    public void sort(){
        System.out.println("冒泡排序中：");
        _bubbleSort();
        System.out.println("\n冒泡排序完成！");
    }

    private void _bubbleSort(){
        int len = huluWaList.size();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1; j++){
                if(compare(j, j+1) > 0){
                    swap(j, j+1, true);
                }
            }
        }
    }
}
