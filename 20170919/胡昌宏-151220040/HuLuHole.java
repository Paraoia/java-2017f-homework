
public class HuLuHole { //葫芦坑，葫芦娃要入坑后进行排序
	private HuLuWas []Hole = new HuLuWas[7]; //坑
	private boolean []is_empty = new boolean[7];  //用于随机排队的布尔数组
	private HuLuWas [] HuLuBros = new HuLuWas[7]; //葫芦兄弟们
	
	public HuLuHole() {
		HuLuBros[0] = new HuLuWas(1, Color.RED);
		HuLuBros[1] = new HuLuWas(2, Color.ORANGE);
		HuLuBros[2] = new HuLuWas(3, Color.YELLOW);
		HuLuBros[3] = new HuLuWas(4, Color.GREEN);
		HuLuBros[4] = new HuLuWas(5, Color.CYAN);
		HuLuBros[5] = new HuLuWas(6, Color.BLUE);
		HuLuBros[6] = new HuLuWas(7, Color.PURPLE);
	}
	
	public void Random_Queue(HuLuWas [] HuLuBros, HuLuWas []Hole, boolean []is_empty) { //随机排队过程
		 int rand;
	        for(int i = 0; i < 7; i++){
	             rand = (int)(1+Math.random()*(7-1+1));
	             while(is_empty[rand-1] == false)
	                  rand = (int)(1+Math.random()*(7-1+1));
	             Hole[rand-1] = HuLuBros[i];
	             is_empty[rand-1] = false;
	        }
	}
	
	public void Initial_empty(boolean []is_empty, int n) {
 		for(int i = 0; i < n; i++)
 			is_empty[i] = true;
 	}
 	
	
	public void Random_Func() {  //随机排队
		Initial_empty(is_empty, 7);
        Random_Queue(HuLuBros, Hole, is_empty);
	}
	
    public void BubbleSort(){  //冒泡排序
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 6 - i; j ++){
                if(Hole[j].rank > Hole[j+1].rank){
                    int k = j + 1;
                    System.out.println(Hole[j].Report_Rank()+"  " + ": " + j + "-->" + k);
                    System.out.println(Hole[j+1].Report_Rank()+"  " + ": " + k+ "-->" + j);
                    HuLuWas temp = Hole[j];
                    Hole[j] = Hole[j+1];
                    Hole[j+1] = temp;
                }
            }
    }
    
    public void QSort(int start, int n){  //二分排序
       if (start < n){
           int point = Partition(start, n);
           QSort(start, point - 1);
           QSort(point + 1, n);
        }
    }
    
    public int Partition(int start, int n){  //二分划分过程
        HuLuWas index = Hole[start];
        int first = start;
        int last = n;
        int index_loc = start;
        while(last > first){
            while (Hole[last].rank > index.rank)
                --last;
            if(index_loc != last){
                System.out.println(Hole[last].Report_Rank()+"  " + '(' + Hole[last].Report_Color() + ')' + ": " + last + "-->" + index_loc);
                System.out.println(index.Report_Rank()+"  "+'(' + index.Report_Color() + ')' +": " + index_loc + "-->" + last);
            }
            Hole[index_loc] = Hole[last];
            Hole[last] = index;
            index_loc = last;
            
            if(first < last){
                ++first;
                while (first < last && Hole[first].rank < index.rank)
                    ++first;
            }
            if(index_loc != first){
                System.out.println(Hole[first].Report_Rank()+"  " + '(' + Hole[first].Report_Color() + ')' +": " + first + "-->" + index_loc);
                System.out.println(index.Report_Rank()+"  "+'(' + index.Report_Color() + ')' + ": " + index_loc + "-->" + first);
            }
            Hole[index_loc] = Hole[first];
            Hole[first] = index;
            index_loc = first;
        }
        return index_loc;
    }
    
    public void Report_all_Rank() {  //按排名报数
    	String s = "待定";
        for(int i = 0; i < 7; i++) {
           s = Hole[i].Report_Rank();
           System.out.print(s+ "  ");
        }
         System.out.println("\n");
    }
    
    public void Report_all_Color() {  //按颜色报数
    	String s = "待定";
        for(int i = 0; i < 7; i++) {
           s = Hole[i].Report_Color();
           System.out.print(s+ "  ");
        }
         System.out.println("\n");
    }
    
}
