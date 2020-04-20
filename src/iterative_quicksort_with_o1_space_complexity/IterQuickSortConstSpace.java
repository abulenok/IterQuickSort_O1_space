
package iterative_quicksort_with_o1_space_complexity;

public class IterQuickSortConstSpace {
        
    public static void QuickSort(int L, int R, long []A){
        int q;
        int n = R;
        while (L < R || R!=n) { 
            if (L < R) {             
                q = Partition(L, R, A);
                
                if(q+1<=n){
                    int m = findMax(q+1, R, A);//finding max value in the right part
                    
                    swap(m, q+1, A);
                    //later we will search for the first value greater than this value which will indicate the beginnig of the next subarray
                }                
                R = q-1;//move to the left subarray                 
            }
            else {                
                if(L==R)
                    L = R+1;
                else
                    L = R+2;
                //at A[L] we have the maximum value of subarray to sort                        
                if(L>n){
                    break;
                }               
                R = findR(L, n, A);//using value at A[L] to find the right bond                
                swap(R, L, A);               
            }
        }
    
    }
    
    public static int findR(int L, int R, long[]A){//finds right bound
        long max_val = A[L];
        for(int i = L; i<=R; i++){
            if(A[i]>max_val){//the first value greater than max_val indicates beginning of the next part (next subaaray to sort)                
                return i-1;  
            }
        }        
        return R;//case when sought right bound is the right bound of the whole array A 
    }
    
    public static int findMax(int L, int R, long[]A){//finds maximum value
        int max_i = L;
        long max_val = A[L];
        for(int i = L; i<=R; i++){
            if(A[i]>max_val){
                max_val = A[i];
                max_i = i;
            }
        }       
        return max_i;
    }
    
    public static int Partition(int L, int R, long[]A) { //Hoare version
        int i = L-1, j = R;       
        long x = A[R]; 
        while(true) {
            while( A[++i] < x ) ;     
            while( j > L && A[--j] > x ) ;
        
            if(i >= j){              
                break;
            }
            else 
                swap(i, j, A); 
        } 
        swap(i, R, A); 
        return i; 
     }

    public static void swap(int i, int j, long[]A) {
        long tmp = A[i]; 
        A[i] = A[j]; 
        A[j] = tmp;
    } 
}
