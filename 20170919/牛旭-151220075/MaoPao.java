public class MaoPao {
	private Brothers brothers;
	
	public MaoPao() {
		brothers = new Brothers();
	}
	public void sort() {
		brothers.showPaiHang();
		for(int i=0; i<brothers.getList().size(); i++) {
			for(int j=0; j<brothers.getList().size()-i-1; j++) {
				if(brothers.getList().get(j).getNumber()>brothers.getList().get(j+1).getNumber()) {
					System.out.println(brothers.getList().get(j).getPaihang()+":"+j+"->"+(j+1));
					System.out.println(brothers.getList().get(j+1).getPaihang()+":"+(j+1)+"->"+j);
					HuLuWa a = brothers.getList().get(j);
					brothers.getList().set(j, brothers.getList().get(j+1));
					brothers.getList().set(j+1, a);
				}
			}
		}
		brothers.showPaiHang();
	}
}