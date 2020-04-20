/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterative_quicksort_with_o1_space_complexity;


public class IterQuickSortConstSpace {
        
    public static void QuickSort(int L, int R, long []A){
        int q;
        //boolean cho = true;
        int n = R;
        while (L < R || R!=n) { //cho
            if (L < R) {
               // System.out.println("Pered Part L "+L);
               // System.out.println("Pered Part R "+R);
                q = Partition(L, R, A);
                if(q+1<=n){
                    int m = findMax(q+1, R, A);//finding max value in the right part
                    //System.out.println("Max "+m);                    
                    swap(m, q+1, A);
                    //later we will search for the first value greater than this value which will indicate the beginnig of the next subarray
                }
                //push([q+1, R]); // na stos prawe podzadanie
               // System.out.println("Res Part "+q);
                R = q-1;//move to the left subarray 
                /*
                if(R!=n)
                    cho = true;               */
                //Print(A);
            }
            else {
                /*
                if(L==R)
                    R--;*/
                if(L==R)
                    L = R+1;
                else
                    L = R+2;
                //at A[L] we have the maximum value of subarray to sort
                
                //System.out.println("Else New Left "+L);
                if(L>n){
                    break;
                }
                 
                R = findR(L, n, A);
               // System.out.println("Else New Right "+R);                
                swap(R, L, A);
                /*
                if(R==n)
                    cho = false;
                else
                    cho = true;*/
            }
        }
    
    }
    
    public static int findR(int L, int R, long[]A){//finds right bound
        //int max_i = L;
        long max_val = A[L];
        for(int i = L; i<=R; i++){
            if(A[i]>max_val){//the first value greater than max_val indicates beginning of the next part (next subaaray to sort)
                
                return i-1;
                //max_i = i;
                //break;
            }
        }
        //if(max_i == L){
            //max_i = R+1;      
        //}
        return R;//case when sought right bound is the right bound of the whole array A
        //return max_i-1;
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
        /*
        if(max_i == L){
            max_i = R;
            A[L] = A[R];
            A[R] = max_val;
        }
        */
        return max_i;
    }
    
    public static int Partition(int L, int R, long[]A) { //Hoare version
        int i = L-1, j = R;
       // System.out.println("Partition Right "+j);
        long x = A[R]; // ostatni element jest dzielÄcy
        while(true) {
            while( A[++i] < x ) ; // i=L po ++i
            // i - pierwszy >= element od x : A[i]âĽx
            while( j > L && A[--j] > x ) ; // j=R-1 po --j
            // j - ostatni, <= element od x: A[j]â¤x lub j==L
            if(i >= j){ //jeĹli kolejnoĹÄ indeksĂłw siÄ zmieni,
              //  System.out.println("I w Part "+i);
                break;
            }// koniec podziaĹu
            else // kolejnoĹÄ nie ulegĹa zmianie, a zatem
                swap(i, j, A); // zamieniamy elementy A[i] i A[j]
        } // koniec pÄtli while(true)
        
        swap(i, R, A); // zamieniamy elementy A[i] i A[R]
        return i; // zwracamy poĹoĹźenie podziaĹu (pivot)
     } // koniec metody partition()

    public static void swap(int i, int j, long[]A) {
        long tmp = A[i]; 
        A[i] = A[j]; 
        A[j] = tmp;
    } 
}
