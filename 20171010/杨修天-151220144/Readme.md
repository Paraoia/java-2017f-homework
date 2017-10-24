# 葫芦娃第三次作业
## 新增对象
- 蛇精
- 爷爷
- 蝎子精
- 小怪

以上对象都是 implements 一个 interface类creature
```
public interface creature {
	
	public void setposition(position a);
	//得到该生物在二维空间中的位置
	public void tellname();
	//告诉该生物种族
	public void getsign();
	//打印该生物具体标识
}

```

因为暂时没有太多各自的操作，所以新增对象大体内部结构差不多

以下用蛇精举例

```
public class snake implements creature {
	private position num;//位置
	snake(position pos)
	{
		num=pos;
	}
	public void setposition(position a)
	{
		this.num=a;
	
	}
	public void getsign()
	{
		System.out.print("蛇");//阵型中打印蛇
	}
	public position getposition()
	{
		
		return num;
	}
	
	public void tellname()
	{
		System.out.print("老大");
	}
	public void tellpos()//报告横纵坐标，调用position对象完成
	{
		num.tellx();
		num.telly();
	}
}
```
position由一维变成二维：
```

	private int x;
	private int y;
	private int judge;//判断该位置是否由生物
	private creature people;
	position(int x,int y,int z)
	{	super();
		this.x=x;
		this.y=y;
		this.judge=z;
	}
	public void rejudge()//有生物，设置为1
	{
		judge=1;
	}
	public void dejudge()//变换队形 生物离开，设为0
	{
		judge=0;
	}
	public void getsign()
	{
		this.people.getsign();
	}
	public int judgeit()
	{
		return this.judge;
	}
	

	public creature getpeople()
	{
		return people;
	}

```

具体战队过程可看做：
- 队列布置好二维空间
- 四种生物初始化站队
- 变换阵型，输出