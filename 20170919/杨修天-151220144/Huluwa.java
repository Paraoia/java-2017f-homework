package Huluwa;

public class Huluwa implements Compare{
	/*public enum EnumTest {
    FRANK("The given name of me"),
    LIU("The family name of me");
    private String context;
    private String getContext(){
   	 return this.context;
    }
    private EnumTest(String context){
   	 this.context = context;
    }
    public static void main(String[] args){
   	 for(EnumTest name :EnumTest.values()){
   		 System.out.println(name+" : "+name.getContext());
   	 }
   	 System.out.println(EnumTest.FRANK.getDeclaringClass());
    }
}} */
	private identity id;
	private Position num;
	Huluwa(identity id)
	{
			this.id=id;
	}
	public void setPosition(Position a)
	{
		this.num=a;
	
	}
	public identity getid()
	{
		return id;
		
	}
	public Position getPosition()
	{
		
		return num;
	}
	public void tellcolor()
	{
		System.out.print(id+" ");
	}
	public void tellname()
	{
		System.out.print(id.context+" ");
	}
	public void tellpos()
	{
		num.tellx();
	}
	@Override
	public boolean bigger(Compare other)//所有实现了Compare接口的类均可作为方法的参数传递进来
	{
		 if (other instanceof  Huluwa)//instanceof判断是否是葫芦娃类，返回值为true or false
	            return this.id.senior>((Huluwa) other).id.senior;
	        else
	            return false;
	}
	
	public static void main(String[] args){
   	 //for(identity name :identity.values()){
		Huluwa brothers[]=new Huluwa[7];
		 for (int i = 0; i < brothers.length; i++)
		 {
	            brothers[i] = new Huluwa(identity.values()[i]);
	     }
		 Quene q=new Quene(brothers);
		 q.baoshu();
		 System.out.println();
		 
		 System.out.println("打乱，报数");
		 q.shuffle();
		 q.baoshu();
		 System.out.println();
		 
		 System.out.println("第一次排序，报数");
		 Sorter s=new Bubblesort();
		 s.sort(q);
		 q.baoshu();
		 System.out.println();
		 
		 System.out.println("打乱，报数");
		 q.shuffle();
		 q.baocolor();
		 System.out.println();
		 
		 System.out.println("更换排序器排序，报数");
		 s=new Insertsort();
		 s.sort(q);
		 q.baocolor();
		 System.out.println();
		 
	}
}

enum identity
{
		红色("老大",1),
		橙色("老二",2),
		黄色("老三",3),
		绿色("老四",4),		
		青色("老五",5),
		蓝色("老六",6),
		紫色("老七",7);
	  public String context;
	  public int senior;
	  private identity(String context,int x)
	  {
	    	 this.context = context;
	    	 this.senior=x;
	   }
	  
}