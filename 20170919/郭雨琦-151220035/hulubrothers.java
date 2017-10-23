import java.util.Random;

public class hulubrothers {
    huluwa[] hulubros;
    int rank[]=new int[7];
    void init(){
        hulubros = new huluwa[7];
        for(int count = 0; count < 7; ++count) {
            hulubros[count]=new huluwa();
            hulubros[count].set(count+1, count+1, count+1);
        }
    }

    void reset(){
        Random random = new Random();
        for(int i = 0; i < 7; ++i){
            rank[i]=random.nextInt(7);
            for(int j = 0; j < i; ++j){
                if(rank[j]==rank[i]){
                    i-=1;
                    break;
                }
            }
        }
        for(int i = 0; i < 7; ++i){
            rank[i]+=1;
            hulubros[i].setrank(rank[i]);
           // System.out.printf("%d ",rank[i]);
        }
      //  System.out.printf("\n");

    }

    int getrank(int i){
        assert(i<=7);
        assert(i>=1);
        for(int k = 0; k < 7; ++k){
            if(hulubros[k].getrank()==i)
                return k;
        }

        return 0;
    }

    void printname(){
        for(int i = 1; i <= 7; ++i){
            hulubros[getrank(i)].sayname();
        }
    }
    void printcolor(){
        for(int i = 1; i <= 7; ++i){
            hulubros[getrank(i)].saycolor();
        }
    }

    void bubblesort(){
        for(int i = 7; i > 0; --i){
            for(int j = 1; j <i; ++j){

                if(getrank(j)>getrank(j+1)){
                    int rankj=getrank(j);
                    int rankjplus1=getrank(j+1);
                    hulubros[rankj].MoveTo(j+1);
                    hulubros[rankjplus1].MoveTo(j);
                   // int temp = rank[j-1];
                   // rank[j-1] = rank[j];
                  //  rank[j]=temp;
                }

                /*
                if(hulubros[j].getrank()>hulubros[j+1].getrank()){
                    int temp = hulubros[j].getrank();
                    hulubros[j].MoveTo(hulubros[j+1].getrank());
                    hulubros[j+1].MoveTo(temp);
                }
                */
            }
        }
    }

    void quicksort(int low, int high){
        int l=low;
        int h= high;
        int pivot=getrank(l);
        while(l<h){
            while(l<h&&(getrank(h)>pivot))
                h--;
                if(l<h){
                    int rankj=getrank(l);
                    int rankjplus1=getrank(h);
                    hulubros[rankj].MoveTo(h);
                    hulubros[rankjplus1].MoveTo(l);
                    l++;
                }
                while(l<h&&(getrank(l)<=pivot))
                    l++;
                if(l<h) {
                    int rankj = getrank(l);
                    int rankjplus1 = getrank(h);
                    hulubros[rankj].MoveTo(h);
                    hulubros[rankjplus1].MoveTo(l);
                    h--;
                }

        }
        if(l>low)quicksort(low,l-1);
        if(h<high)quicksort(l+1,high);
    }
}
