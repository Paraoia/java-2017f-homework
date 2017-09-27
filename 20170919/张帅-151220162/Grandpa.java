import java.util.Random;

public class Grandpa {
	Boy []boys = new Boy[7];

	public static void main(String[] args){
		Grandpa grdpa = new Grandpa();

		System.out.println("冒泡排序{");
		grdpa.randSeq(); //随机排队
		grdpa.bubbleSort(); //根据排行冒泡排序
		System.out.println("}");
		grdpa.numberOff(); //报数

		grdpa.randSeq(); //随机排队
		System.out.println("快速排序{");
		grdpa.boysQuickSort(); //根据颜色快速排序
		System.out.println("}");
		grdpa.colorOff(); //报颜色
	}

	Grandpa(){
		//各葫芦娃有序
		for(int i=0;i<7;i++)
			boys[i] = new Boy(i,Color.values()[i]);
	}

	public void bubbleSort(){
		for(int i=0;i<boys.length-1;i++)
			for(int j=0;j<boys.length-1-i;j++)
				if(boys[j].getNumber()>boys[j+1].getNumber())
					swap(boys, j, j+1);
	}

	public void numberOff(){
		System.out.print("报数：");
		for(int i=0;i<boys.length;i++)
			boys[i].putNumber();
		System.out.print('\n');
	}

	public void colorOff(){
		System.out.print("报颜色：");
		for(int i=0;i<boys.length;i++)
			boys[i].putColor();
		System.out.print('\n');
	}

	public void boysQuickSort(){
		quickSort(boys, 0, boys.length-1);
	}

	//打乱顺序
	private void randSeq(){
		Random rand = new Random();
		for(int i=0;i<7;i++) {
			int tmp = rand.nextInt(7);
			Boy temp = boys[i];
			boys[i] = boys[tmp];
			boys[tmp] = temp;
		}
	}

	private void swap(Boy[] boys, int x, int y){
		Boy temp = boys[x];
		boys[x] = boys[y];
		boys[y] = temp;
		boys[x].moveTo(x,y);
		boys[y].moveTo(y,x);
	}

	private void quickSort(Boy[] boys, int begin, int end){
		if(end<=begin)
			return;

		Color pivotValue = boys[end].getColor();
		int p = begin;
		for(int i=begin;i<end;i++)
			if(boys[i].getColor().compareTo(pivotValue)<0){
				swap(boys, i, p);
				p++;
			}
		swap(boys, p, end);

		quickSort(boys, begin, p-1);
		quickSort(boys, p+1, end);
	}
}
