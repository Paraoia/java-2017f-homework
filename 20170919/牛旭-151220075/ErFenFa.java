public class ErFenFa {
	private Brothers brothers;
	public ErFenFa() {
		brothers = new Brothers();
	}
	public void sort() {
		brothers.showColor();
		for(int i=1 ; i<brothers.getList().size() ; i++) {
			int left=0, right=i-1;
			HuLuWa num=brothers.getList().get(i);
			while(left<=right) {
				int middle=(left+right)/2;
				if(num.getNumber()<brothers.getList().get(middle).getNumber()) 
					right=middle-1;
				else
					left=middle+1;
			}
			for(int j=i-1; j>=left; j--) {
				System.out.println(brothers.getList().get(j).getPaihang()+":"+j+"->"+(j+1));
				brothers.getList().set(j+1, brothers.getList().get(j));
			}
			System.out.println(num.getPaihang()+":"+i+"->"+left);
			brothers.getList().set(left, num);
		}
		brothers.showColor();
	}
}