package Huluwa;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quene {
	private Position[] duilie;
	private Huluwa[] brothers;
	private Grandpa oldman;
	private Luoluo[] guai;
	private Xiezijing laoer;
	private	Snake laoda;
	private int hang;
	private int lie;
	Quene(Huluwa[]brothers)
	{	this.hang=16;
		this.lie=16;
		this.duilie=new Position [hang*lie];
		for(int i=0;i<hang;i++)
			for(int j=0;j<lie;j++)
				duilie[i*hang+j]=new Position(i,j,0);
		this.brothers=brothers;
		for(int i=0;i<brothers.length;i++)
			{this.duilie[(i+4)*hang+1]=new Position(i+4,1,1);
			 this.duilie[(i+4)*hang+1].setpeople(brothers[i]);
			}
		oldman=new Grandpa(duilie[7*16]);
		duilie[7*16].rejudge();
		this.duilie[7*16].setpeople(oldman);
		
		guai=new Luoluo[6];
		for(int j=0,i=15,k=4;j<6;i--,j++,k++)
			{guai[j]=new Luoluo(duilie[k*hang+i]);
			 duilie[k*hang+i].rejudge();
			 this.duilie[k*hang+i].setpeople(guai[j]);
			}
		
		laoer=new Xiezijing(duilie[169]);
		duilie[169].rejudge();
		this.duilie[169].setpeople(laoer);
		
		laoda=new Snake(duilie[127]);
		duilie[127].rejudge();
		this.duilie[127].setpeople(laoda);
	}
	public void zhenxing()
	{	
		for(int i=0;i<hang;i++)
		 {for(int j=0;j<lie;j++)
			 haspeople(i,j);
		 System.out.println();
		 }
	}
	public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = brothers.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position pos=brothers[i].getPosition();
            brothers[index].getPosition().setpeople(brothers[i]);
            pos.setpeople(brothers[index]);
               
        }
    }
	public void reset()
	{	laoer.getPosition().dejudge();
		
		for(int j=3,i=13,k=8;j<6;i++,j++,k++)
		{guai[j].getPosition().dejudge();
		 duilie[k*hang+i].rejudge();
		 this.duilie[k*hang+i].setpeople(guai[j]);
		}
		duilie[124].rejudge();
		this.duilie[124].setpeople(laoer);
	}
	public void haspeople(int i,int j)
	{
		if(duilie[i*16+j].judgeit()==1)
			duilie[i*16+j].getsign();
			
		else
			System.out.print("   ");
	}
	public Position[]getpositios()//当前队列储存有葫芦娃站位信息，其他对象可通过此方法获取
	{
		return duilie;
	}
	public void baoshu()//打印当前队列储存有葫芦娃站位信息
	{
		for(Position a:this.duilie)
			{//a.reportnum();
			 a.reportpeo();
			 
			}
		System.out.println();
	}
	
	
}
