package HuLu;
import java.util.*;
public class Space {
	
	private int width;
	private int length;
	private Position[][] positions;
	
	public Space(int width,int length) {
		this.width=width;
		this.length=length;
        this.positions = new Position[length][width];
        for(int i=0;i<length;i++)
        	for(int j=0;j<width;j++)
        		this.positions[i][j]=new Position(i,j);
    }
	

	public int getWidth(){
		return this.width;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public Position[][] getPositions(){
		return this.positions;
	}
	public void printSpace(){
		for(int i=0;i<length;i++){
			for(int j=0;j<width;j++){
				if(positions[i][j].getHolder()==null)
					System.out.print("***\t");
				else
					System.out.print(positions[i][j].getHolder().getName()+"\t");
			}
			System.out.println("");
		}
		
	}
	public static void main(String[] args) {

        Huluwa[] huluwa = new Huluwa[7];
        for (int i = 0; i < huluwa.length; i++) {
            huluwa[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }
        Random random = new Random();
        for (int i = 0; i < huluwa.length; i++) {
        	int j=Math.abs(random.nextInt())%7;
        	Huluwa temp=huluwa[i];
        	huluwa[i]=huluwa[j];
        	huluwa[j]=temp;
        }
        for (int i = 0; i < huluwa.length; i++) {
            huluwa[i].report();
        }
        
        Louluo[] louluo=new Louluo[8];
        
        for (int i = 0; i < louluo.length; i++) {
        	louluo[i]=new Louluo();
        }
        for (int i = 0; i < louluo.length; i++) {
            louluo[i].report();
        }
        Space space=new Space(16,16);
        new ChangSheZhen().arrange(space, 0, 0, huluwa, huluwa.length);
        new BubbleSorter().sortCol(space, 0, 0,  huluwa.length);
        new HengEZhen().arrange(space, 0, 6, louluo, louluo.length);
        //new FangYuanZhen().arrange(space, 0, 5, louluo, louluo.length);
//        space.setZhenArranger(new ChangSheZhen());
//        space.zhenArranger.arrange(space,0,0,huluwa,7);
        System.out.println("");
        space.printSpace();
//        space.setSorter(new BubbleSorter());
//        space.sorter.sort(positions[][0], 7);
    }
	
}
