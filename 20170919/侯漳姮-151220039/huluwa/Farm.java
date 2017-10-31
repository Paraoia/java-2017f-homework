package huluwa;



class Tree{
  Huluxiongdi seats;
}
public class Farm {
          Tree []tree;
          public Farm(Huluxiongdi bro[])
          {
        	  tree=new Tree[bro[0].COUNT];
        	  
        	for(int i=0;i<bro[0].COUNT;i++){
      			tree[i]=new Tree();
      		}
      		tree[0].seats=bro[2];
      		tree[1].seats=bro[4];
      		tree[2].seats=bro[1];
      		tree[3].seats=bro[6];
      		tree[4].seats=bro[0];
      		tree[5].seats=bro[5];
      		tree[6].seats=bro[3];
          
          }
          public void mess()
          {
        	    //change_rank(0,5);
        	    Huluxiongdi t=tree[0].seats;
          	  tree[0].seats=tree[5].seats;
          	  tree[5].seats=t;
        	    //change_rank(1,6);
        	    t=tree[1].seats;
          	  tree[1].seats=tree[6].seats;
          	  tree[6].seats=t;
        	    //change_rank(2,4);
        	    t=tree[2].seats;
          	  tree[2].seats=tree[4].seats;
          	  tree[4].seats=t;
        	   // change_rank(0,6);
        	    t=tree[0].seats;
          	  tree[0].seats=tree[6].seats;
          	  tree[6].seats=t;
        	    //change_rank(3,5);
        	    t=tree[3].seats;
          	  tree[3].seats=tree[5].seats;
          	  tree[5].seats=t;
        	    //change_rank(4,1);
        	    t=tree[4].seats;
          	  tree[4].seats=tree[1].seats;
          	  tree[1].seats=t;
            
          }
          public void bublle_sort()
          {
        	  for(int i=0;i<7;i++)
        	  {
        		  for(int j=i+1;j<7;j++)
        		  {
        		      if(tree[j].seats.seat<tree[i].seats.seat)
        		      {
        		    	  change_rank(i, j);
        		      }
        		  }
        	  
        	  }
          }
          public void tow_depart()
          {
        	  for (int i=0;i<7;i++)
        	  {
        		  int head=0;
        		  int tail=i-1;
        		  int mid=(head+tail)/2;
        		  
        		  while(head<=tail)
        		   {
        			  mid=(head+tail)/2;
        			  if(tree[i].seats.color>tree[mid].seats.color)
        				  head=mid+1;
        			  else
        				  tail=mid-1;
        			  
        		   }
        		  
        		  for(int j=i-1;j>=tail+1;j--)
        		  {
        			  change_rank(j, j+1);
        		          
        		  }
        		  
        	     
        	  }
  			  
  			  
          }
          public void change_rank(int i,int j)
          {
        	  tree[i].seats.change_sit(i, j);
        	  tree[j].seats.change_sit(j, i);
        	  Huluxiongdi t=tree[i].seats;
        	  tree[i].seats=tree[j].seats;
        	  tree[j].seats=t;
          }
          public void print_bro()
          {
        	  for(int i=0;i<7;i++)
        		  System.out.print(tree[i].seats.getname()+" ");
        	      System.out.println();
          
          }
          public void print_color()
          {
        	  for(int i=0;i<7;i++)
        		  System.out.print(tree[i].seats.getcolor()+" ");
        	  System.out.println();
        	  
          }
          
}
