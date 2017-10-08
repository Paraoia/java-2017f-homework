
public class SelectSort {
        public static void main(String[] args) {
                
                int[] a = {32,100,53,54,12,65,63,98,43};
                
                for(int i=0; i< a.length; i++)
                {
                	int k = i;
                	for(int j = i + 1;j < a.length;j++) {
                		if(a[j] < a[k])
                			k = j;
                	}
                	if(k != i) {
                		int tmp = a[k];
                		a[k] = a[i];
                		a[i] = tmp;
                	}
                        
                }
                for(int i = 0;i < a.length;i++) {
                	System.out.println(a[i]+" ");
                }
        }
}

