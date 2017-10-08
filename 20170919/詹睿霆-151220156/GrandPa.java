
public class GrandPa{
	CalabashBro[] Huluwas;
	Queue queue;
	public void NameCalabashs(){
		Huluwas=new CalabashBro[7];
		for(int i=0;i<7;i++){
			Huluwas[i]=new CalabashBro(i+1);
		}
	}
	public void SeeByRandom(){
		System.out.println("\n爷爷：你们随便站吧");
		queue=new Queue();
		queue.QueueByRandom(Huluwas);
	}
	public void SeeByColor(){
		System.out.println("\n爷爷：按颜色站给我看看");
		queue.QueueByColor();
	}
	public void SeeBySenisority(){
		System.out.println("\n爷爷：按长幼站给我看看");
		Queue temp=new Queue();
		queue.QueueBySeniority();
	}
}

