package HuLuBro;
import java.util.*;
public class Input {
	public Input(){
		
	}
	public void MessUp(HuLuFamily hlf){
		Random random = new Random();
		
		for(int i=0;i<hlf.getCount();i++){
			hlf.exchange(i, Math.abs(random.nextInt())%7,false);
		}
		for(int i=0;i<hlf.getCount();i++){
			hlf.exchange(i, Math.abs(random.nextInt())%7,false);
		}
	}
}
