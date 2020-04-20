
package iterative_quicksort_with_o1_space_complexity;


import static iterative_quicksort_with_o1_space_complexity.IterQuickSortConstSpace.QuickSort;
import java.util.Scanner;

/****
In main function:
The first value given is a positive integer denoting the number of the data sets.
Each dataset contains:
-A positive integer indicating the amount of the data set being loaded.
-Core data of a set equal to the previously entered value, being integers within the range <-2^63;2^63-1>  
****/
        
public class Iterative_QuickSort_with_O1_space_complexity {

    public static Scanner in = new Scanner(System.in);
        
    public static void main(String[] args) {
        int k = in.nextInt();
        int n;
        long []arr;
        for(int i = 0; i < k; i++){
            n = in.nextInt();
           
            arr = new long[n];
            for(int x = 0; x<n; x++){     
                arr[x] = in.nextInt();        
            }           
            QuickSort(0, n-1, arr);
            Check(arr);
            Print(arr);            
        }    
    }
    
    public static void Print(long[]arr){
        int n = arr.length;
        for(int x = 0; x<n; x++){            
            System.out.print(arr[x]+" ");        
        }
        System.out.println(); 
    }
    public static void Check(long []arr){
        int n = arr.length;
        for(int x = 0; x<n; x++){            
            if(x+1<n && arr[x]>arr[x+1]){
                System.out.print("ERROR");
                System.out.println(); 
            }        
        }
    }
}

/*
test example:

in:

4
5 
3 2 1 4 5
3 
2 3 1
15
34 15 5 6 300 1 13 11 187 4 0 3 10 7 1232
12
5 6 32 567 2 656 24 43 86 20 13 97

out:

1 2 3 4 5 
1 2 3 
0 1 3 4 5 6 7 10 11 13 15 34 187 300 1232 
2 5 6 13 20 24 32 43 86 97 567 656

*/