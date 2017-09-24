package HuLuBro;

public class Test {
	public static void main(String []args){
		HuLuFamily hlf=new HuLuFamily();
		Input input=new Input();
		input.MessUp(hlf);
		Output output=new Output();
		output.printName(hlf);
		System.out.println("");
		Sort sort=new Sort();
		sort.BubbleSort(hlf);
		output.printName(hlf);
		
		System.out.println("");
		input.MessUp(hlf);
		output.printName(hlf);
		System.out.println("");
		sort.DivideSort(hlf);
		output.printColor(hlf);
		
	}
}
