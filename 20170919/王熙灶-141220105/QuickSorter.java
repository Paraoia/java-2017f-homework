/**
 * 上古神器之（更强大的）快速排序器，能让葫芦军团的葫芦娃们乖乖按照次序排队
 */

public class QuickSorter {
    public void quickSort(Crops crops, int left, int right) {
        int index = partition(crops, left, right);
        if(left < index - 1) {
            quickSort(crops, left, index - 1);
        }
        if(right > index) {
            quickSort(crops, index, right);
        }
    }

    public int partition(Crops crops, int left, int right) {
        int _left = left, _right = right;
        int pivot = (_left + _right) / 2;

        while (_left <= _right) {
            while (crops.calaBros[_left].get_intNo() < crops.calaBros[pivot].get_intNo()) {
                _left++;
            }
            while (crops.calaBros[_right].get_intNo() > crops.calaBros[pivot].get_intNo()) {
                _right--;
            }

            if(_left <= _right) {
                crops.swap(_left, _right);
                _left++;
                _right--;
            }
        }
        return _left;
    }
}