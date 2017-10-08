/**
 * 上古神器之冒泡排序器，能让葫芦军团的葫芦娃们乖乖按照次序排队
 */

public class BubbleSorter {
    public void bubbleSort(Crops crops) {
        int size = 7;
        for (int i = size -1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(crops.calaBros[j].get_intNo() > crops.calaBros[j+1].get_intNo()) {
                    crops.swap(j, j+1);
                }
            }
        }
    }
}