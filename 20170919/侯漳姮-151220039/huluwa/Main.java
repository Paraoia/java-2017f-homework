package huluwa;

public class Main {
	public static void main(String []args)
	{
		Huluxiongdi bro[]=new Huluxiongdi[7];
		
			for(int i=0;i<7;i++)
			{
			  bro[i]=new Huluxiongdi(i+1,i+1,i);
			}
			
			Farm m=new Farm(bro);
			System.out.println("Before sort:");
			m.print_bro();
			System.out.println("sorting:");
			m.bublle_sort();
			System.out.println("After sort:");
			m.print_bro();
			System.out.println();
			System.out.println("Mess up");
			System.out.println();
			m.mess();
			System.out.println();
			System.out.println("Before sort:");
			m.print_color();
			System.out.println("sorting:");
			m.tow_depart();
			System.out.println("After sort:");
			m.print_color();
			//m.print_bro();
			
		
	}
}
