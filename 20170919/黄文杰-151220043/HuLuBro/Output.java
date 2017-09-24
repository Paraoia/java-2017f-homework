package HuLuBro;

public class Output {
	public Output(){
		
	}
	public void printName(HuLuFamily hlf){
		int count=hlf.getCount();
		for(int i=0;i<count;i++)
			System.out.print(hlf.getName(hlf.getHuLu(i))+' ');
		System.out.print("\n");
	}
	public void printColor(HuLuFamily hlf){
		int count=hlf.getCount();
		for(int i=0;i<count;i++)
			System.out.print(hlf.getColor(hlf.getHuLu(i))+' ');
		System.out.print("\n");
	}
}
