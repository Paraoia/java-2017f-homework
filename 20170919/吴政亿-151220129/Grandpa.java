public class Grandpa {
	public Queue calabashes = new Queue();
	public Grandpa() {
		calabashes.EnQueue(new Calabash("老大", 1, COLOR.Red));
	    calabashes.EnQueue(new Calabash("老二", 2, COLOR.Orange));
	    calabashes.EnQueue(new Calabash("老三", 3, COLOR.Yellow));
	    calabashes.EnQueue(new Calabash("老四", 4, COLOR.Green));
	    calabashes.EnQueue(new Calabash("老五", 5, COLOR.Cyan));
	    calabashes.EnQueue(new Calabash("老六", 6, COLOR.Blue));
	    calabashes.EnQueue(new Calabash("老七", 7, COLOR.Purple));
	}
	
	//冒泡排序
    public void bubbleSort() {
        for (int i = 0; i < calabashes.Size(); i++) {
            for (int j = 0; j < calabashes.Size() - 1 - i; j++) {
                if ((calabashes.GetCalabash(j).GetIndex()) > (calabashes.GetCalabash(j + 1).GetIndex())) {
                    calabashes.swap(j, j+1);
                }
            }
        }
    }
    
  //快速排序
    public void quickSort(int start, int end){
    	int i = start,j = end;
    	while(i<j) {
    		while(j>i && calabashes.GetCalabash(j).GetIndex() >= calabashes.GetCalabash(i).GetIndex())
    			j--;
    		if(i<j) {
    			calabashes.swap(i, j);
    			i++;
    		}
    		while(i<j && calabashes.GetCalabash(i).GetIndex() <= calabashes.GetCalabash(j).GetIndex()) 
    			i++;
    		if(i<j) {
    			calabashes.swap(i, j);
    			j--;
    		}
    	}
    	 if(start<i-1)
    		 quickSort(start, i-1);
    	 if(i+1<end)
    		 quickSort(i+1, end);
    }
	
    public static void main(String[] args) {
    	//初始化一个爷爷
    	Grandpa grandpa = new Grandpa();
    	//爷爷弄乱他们
    	grandpa.calabashes.shuffle();
    	//爷爷冒泡排序葫芦娃
    	grandpa.bubbleSort();
    	//葫芦娃报名字
    	grandpa.calabashes.ReportName();
    	//爷爷弄乱他们
    	grandpa.calabashes.shuffle();
    	//爷爷快速排序葫芦娃
    	grandpa.quickSort(0, grandpa.calabashes.Size()-1);
    	//葫芦娃报颜色
    	grandpa.calabashes.ReportColor();

    	
    }
}

