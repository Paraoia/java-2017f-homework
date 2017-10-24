
/*
 * writer:  ZLX
 * time:    2017/09/29
 * purpose: homework/practice
 * 
 */
public class Huluwas{
	public static void main(String[] args){
		Huluwa s= new Huluwa();// create a world on huluwas's story
		int[] a={1,2,3,4,5,6,7};//huluwas save grandpa's order;Initialization
		s.plant_huluwu(s.h);//huluwa's birth
		s.save_grandpas_order(a);//reset the order
		System.out.println("第一次救爷爷的顺序：");
		s.report_name(s.h,a);
		System.out.println("失败，重新调整战斗顺序：");
		s.bubblesort(s.h,a);
		System.out.println("重新调整后的战斗顺序：");
		s.report_name(s.h,a);
		s.reset_the_order(a);//reset the order
		System.out.println("第二次救爷爷的顺序：");
		s.report_color(s.h,a);
		System.out.println("失败，重新调整战斗顺序");
		s.binarysort(s.h,a,0,6);
		System.out.println("重新调整后的战斗顺序：");
		s.report_color(s.h,a);
	}
}


class Huluwa {
      class hlw{
    	  private int id;
    	  private String color;
    	  private String name;
    	  public hlw(int id,String color,String name)
    	  {
    		  this.id=id;
    		  this.color=color;
    		  this.name=name;
    	  }
      }
      hlw[] h=new hlw[7];//create h for huluwas as their home;
      void plant_huluwu(hlw[] h)
      { 
        h[0]=new hlw(1,"红色","老大");
        h[1]=new hlw(2,"橙色","老二");
        h[2]=new hlw(3,"黄色","老三");
        h[3]=new hlw(4,"绿色","老四");
        h[4]=new hlw(5,"青色","老五");
        h[5]=new hlw(6,"蓝色","老六");
        h[6]=new hlw(7,"紫色","老七");
      }
      
      void save_grandpas_order(int[] s)
      {
    	 s[0]=3;
    	 s[1]=4;
    	 s[2]=5;
    	 s[3]=1;
    	 s[4]=7;
    	 s[5]=6;
    	 s[6]=2;
      }
      
      
      void reset_the_order(int[] s)
      {
    	  s[0]=2;
    	  s[1]=5;
    	  s[2]=3;
    	  s[3]=6;
    	  s[4]=7;
    	  s[5]=1;
    	  s[6]=4;
      }
      
      void report_name(hlw[] h,int[] s)
      {
    	  for(int i=0;i<7;i++)
  	    	System.out.print(h[s[i]-1].name+" ");
    	  System.out.print("\n");
      }
      
      void report_color(hlw[] h,int[] s)
      {
             for(int i=0;i<7;i++)
    	    	System.out.print(h[s[i]-1].color+" ");
    	     System.out.print("\n");  
    	   
      }
      
      void report_tran(hlw[]h,int s,int i,int j)
      {
    	  System.out.println(h[s-1].name+":"+i+"->"+j);
      }
      
      void bubblesort(hlw[] h,int[] s)
      {
    	  for (int i = 0; i < 7; i++)
          {   
  			
              for (int j = i; j < 7; j++)
              {
                  if (s[i] > s[j])
                  {
                      int temp = s[i];
                      s[i] = s[j];
                      s[j] = temp;
                      report_tran(h,s[i],j,i);
                      report_tran(h,s[j],i,j);
                  }
              }
          }
      }
      
      void binarysort(hlw[] h,int[] s,int left,int right)
      {
    	  int low, middle, high;
          int temp;
      for (int i = left + 1; i <= right; i++) {
              temp = s[i];
              low = left;
              high = i - 1;
              while (low <= high) {
                  middle = (low + high) / 2;
                  if (s[i] < s[middle])
                      high = middle - 1;
                  else
                      low = middle + 1;
          }

              for (int j = i - 1; j >= low; j--)
              {       s[j + 1] = s[j];
               	     report_tran(h,s[j+1],j,j+1);
              }
              s[low] = temp;
              if(low!=i)
              { report_tran(h,s[i],low,i);
              report_tran(h,s[low],i,low);
              }
          }
      }
      
      
}


