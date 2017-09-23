
public class Sort {
	public static void main(String[] args) {
		Sort s;
		if (args.length > 0) {
			s = new Sort(args);
		}
		else {
			Integer [] arr = {32,43,53,54,32,65,63,98,43,23};
			s = new Sort(arr);
		}
		s.sort(s.S_ASC);
		s.output("\n");
	}
	
	
	private Integer[] vector;
	final Integer S_ASC = 0x1;
	final Integer S_DESC = 0x10;
	final Integer S_MASK = 0X11;	
	public Sort(String[] args){
		if (args.length >= 1) {
			Integer [] arr = new Integer[args.length];
			for (int i = 0; i < args.length; i++) {
				arr[i] = Integer.parseInt(args[i]);
			}
			this.vector = new Integer[args.length];
			this.vector = arr;
		}
		else {
			error("Need Args", -1);
		}
	}
	public Sort(Integer[] args){
		if (args.length >= 1) {
			this.vector = new Integer[args.length];
			this.vector = args;
		}
		else {
			error("Need Args", -1);
		}
	}
	public void error(String msg, Integer status) {
		System.out.println("ERROR : " + msg);
		System.exit(status);
	}	
	public Integer sort(Integer flag){
		if (vector.length <= 0){
			error("Vector is empty!!!", -1);
		}
		if ((S_MASK & flag) == 0) {
			error("Illegal flag!!!", -1);
		}
		for(int i = 0; i < vector.length; i++){
			for(int j = i + 1; j < vector.length; j++){
				if ( (flag & S_ASC) != 0 ? vector[i] > vector[j] : vector[i] < vector[j] ) {
					Integer tmp = vector[i];
					vector[i] = vector[j];
					vector[j] = tmp;
				}
			}
		}
		return 1;
	}
	public Integer output(String IFS) {
		if (vector.length <= 0){
			error("Vector is empty!!!", -1);
		}
		for(int i = 0; i < vector.length; i++){
			System.out.print(vector[i]+IFS);
		}
		return 1;
	}
}
