package BottleGourdBaby;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author wxz
 *2017.9.24
 */
public class BottleGourdBaby{
	public static void main(String[] args){                //主函数
		//Create 7 boys
	//	BGB Fst =new BGB("red", "1stBGBaby",1);
	//	BGB Snd =new BGB("orange", "2ndBGBaby",2);
	//	BGB Thd =new BGB("yellow","3rdBGBaby",3);
	//	BGB Fth =new BGB("green","4thBGBaby",4);
	//	BGB Fvth =new BGB("cyan","5thBGBaby",5);
	//	BGB Sxth =new BGB("blue","6thBGBaby",6);
	//	BGB Seth =new BGB("purple","7thBGBaby",7);


		BGB []brothers = new BGB[7];
		SortBox box1 = new SortBox();
		//Create 7 boys
		for(int i=0;i<brothers.length;i++){
		brothers[i] = new BGB(COLOR.values()[i],SENIORITY.values()[i],0);
		}
		//3,7,5,1,6,4,2
	//	box1.add(Thd);box1.add(Seth);box1.add(Fvth);box1.add(Fst);
	//	box1.add(Sxth);box1.add(Fth);box1.add(Snd);
		box1.add_init(brothers);
		System.out.println("before BubbleSort  Sort:");
	//	box1.PrintBy_Rank();
		box1.PrintByRank();
		System.out.println("-------------------------------------------");
		System.out.println("BubbleSort  details:");		
		box1.SortByBubble();   //BubbleSort
		System.out.println("-------------------------------------------");
		System.out.println("After Sort:");
		box1.PrintByRank();
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		SortBox box2 = new SortBox();
		//3,7,5,1,6,4,2
	//	box2.add(Thd);box2.add(Seth);box2.add(Fvth);box2.add(Fst);
	//	box2.add(Sxth);box2.add(Fth);box2.add(Snd);
	    box2.add_init(brothers);
		System.out.println("before BinarySort Sort:");
		box2.PrintByColor();
		System.out.println("-------------------------------------------");
		System.out.println("BinarySort details:");
		box2.SortByBinary();    //BinarySort
		System.out.println("-------------------------------------------");
		System.out.println("After Sort:");
		box2.PrintByColor();
		

	}

}

enum COLOR {
    red, orange, yellow, green, cyan, blue, purple
}
enum SENIORITY {
    one,two,three,four,five,six,seven
}

class BGB{                  //葫芦娃类
	int _rank;
	COLOR color;
	SENIORITY rank;
	public BGB(COLOR col,SENIORITY ran,int no){    //]constructed function
		color = col;
		rank = ran;
		_rank = no;
	}
	public BGB(BGB a){                        //]constructed function
		color = a.color;
		rank = a.rank;
		_rank = a._rank;
	}
	public void GetColor(){//������ɫ
		System.out.print(color);
	}
	
	public void GetRan(){//��������
		System.out.print(rank);
	}

}
class SortBox{	          //一个排序类，能加载进葫芦娃队列，打乱，并且进行冒泡，二分排序，然后按照排行，颜色输出
	int count=0;
	BGB[] Array ;

	public void add_init(BGB []a){ //initial and add brothers to SortBox
		Array =new BGB[a.length];
		Array =a;
		List list = Arrays.asList(Array);
		Collections.shuffle(list);
		Random rand = ThreadLocalRandom.current();
		for(int i=0;i<a.length;i++){
		switch (Array[i].color){
			case red: Array[i]._rank =1;break;
			case orange: Array[i]._rank=2;break;
			case yellow: Array[i]._rank =3;break;
			case green: Array[i]._rank =4;break;
			case cyan: Array[i]._rank =5;break;
			case blue: Array[i]._rank =6;break;
			case purple: Array[i]._rank =7;break;
		}

		}

		count=a.length;
	}
	public int GetCount(){return count;}
	
	public void SortByBubble(){
		for(int i=0;i<count-1;i++){
			for(int j=i+1;j<count;j++){
				if(Array[i]._rank>Array[j]._rank){
					BGB Temp =Array[i];
					Array[i] = Array[j];
					Array[j] = Temp;					
					System.out.println(Array[i].rank+":	"+j+"->"+i+";	"+Array[j].rank+":	"+i+"->"+j+";");
				}
			}
		}
	}
	public void SortByBinary(){
		int[] indexs ={0,1,2,3,4,5,6};
		Random rand = new Random();
		int index = rand.nextInt(indexs.length);		
		int key = indexs[index];
		
		int high,low;
		BGB temp ;
		for(int i=1;i<count;i++){
			temp = new BGB(Array[i]);
			low =0;
			high = i-1;
			while(low <= high){
				key = (low + high)/2;
				if(Array[key]._rank>temp._rank){
					high =key - 1;
				}else low =key+1;
			}
			
			for(int j=i-1;j>high;j--){
				Array[j+1] = Array[j];
			}
			Array[high +1] = temp;	
			System.out.println(Array[i].rank+":	"+(high+1)+"->"+i+";	"+Array[high+1].rank+":	"+i+"->"+(high+1)+";");
		}
		
	}
	public void PrintByColor(){
		for(int i=0;i<count;i++){
			System.out.println(Array[i].rank+":	My color is	"+Array[i].color+";");
		}
	}
	public void PrintByRank(){
		for(int i=0;i<count;i++){
			System.out.println(Array[i].rank+":	I came	"+(i+1)+";");
		}
	}
	public void PrintBy_Rank(){
		for(int i=0;i<count;i++){
  		System.out.println("I came	"+(Array[i]._rank)+";");
		}
    }

 }



