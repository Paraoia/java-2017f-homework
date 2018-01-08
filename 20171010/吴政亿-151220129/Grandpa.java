public class Grandpa extends Creature{
    public Queue calabashes = new Queue();

    public Grandpa() {
        type=CreatureType.Grandpa;
        name=new String("爷爷");
        calabashes.EnQueue(new Calabash("老大", 1, COLOR.Red));
        calabashes.EnQueue(new Calabash("老二", 2, COLOR.Orange));
        calabashes.EnQueue(new Calabash("老三", 3, COLOR.Yellow));
        calabashes.EnQueue(new Calabash("老四", 4, COLOR.Green));
        calabashes.EnQueue(new Calabash("老五", 5, COLOR.Cyan));
        calabashes.EnQueue(new Calabash("老六", 6, COLOR.Blue));
        calabashes.EnQueue(new Calabash("老七", 7, COLOR.Purple));
    }

    //冒泡排序
    private void bubbleSort() {
        for (int i = 0; i < calabashes.Size(); i++) {
            for (int j = 0; j < calabashes.Size() - 1 - i; j++) {
                if ((((Calabash)(calabashes.GetCreature(j))).GetIndex()) > (((Calabash)(calabashes.GetCreature(j+1))).GetIndex())) {
                    calabashes.swap(j, j + 1);
                }
            }
        }
    }

    //快速排序
    private void quickSort(int start, int end) {
        int i = start, j = end;
        while (i < j) {
            while (j > i && (((Calabash)(calabashes.GetCreature(j))).GetIndex()) >= (((Calabash)(calabashes.GetCreature(i))).GetIndex()))
                j--;
            if (i < j) {
                calabashes.swap(i, j);
                i++;
            }
            while (i < j && (((Calabash)(calabashes.GetCreature(i))).GetIndex()) <= (((Calabash)(calabashes.GetCreature(j))).GetIndex()))
                i++;
            if (i < j) {
                calabashes.swap(i, j);
                j--;
            }
        }
        if (start < i - 1)
            quickSort(start, i - 1);
        if (i + 1 < end)
            quickSort(i + 1, end);
    }

    public void ShuffleCalabash() {
        //爷爷弄乱他们
        calabashes.shuffle();
    }

    public void SortCalabash() {
        //爷爷冒泡排序葫芦娃
        bubbleSort();
        //爷爷快速排序葫芦娃
//        quickSort(0, calabashes.Size() - 1);
    }

    public void CalabashEcho(){
        //葫芦娃报颜色
//        calabashes.ReportColor();
        //葫芦娃报名字
        calabashes.Echo();
    }

}

