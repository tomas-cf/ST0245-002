/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio02;

/**
 *
 * @author NN
 */
import java.util.Arrays;

public class Laboratorio02{

  
  // Sorts an array using Insertion Sort
  public static void InsertionSort(int[] A) //O(n^2)
  {
      for (int i = 1; i < A.length; i++) {   //O(n)
          int aux = A[i];
          int j= i-1;               
          while (j >= 0 && A[j] < aux) {    //O(n) en el peor de los casos 
              //System.out.println(A[j+1]);
              A[j+1]= A[j];
              j=j-1;
          }
          
          A[j+1]= aux;
          //System.out.println("A[i]: "+A[i]+" key: "+key);
      }                                         //O(n^2)
  }

      // Sorts an array using Merge Sort
	public static void mergeSort(int [ ] a)  // O(n*log n)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, 0,  a.length - 1);
	}

        // Sorts an array using Merge Sort
	private static void mergeSort(int [ ] a, int left, int right) // O(n*log n)
	{
            if(left<right){                   
                int medio = (left+right)/2; 
                mergeSort(a,left,medio);   //T(n/2)
                mergeSort(a,medio+1,right);  //T(n/2)       
                                             //O(log n +1)
                merge(a,left,medio,right);   //O(n)
            }
        }                                    //O(n*log n)  

    // Merges two sorted arrays
    private static void merge(int[ ] a, int left, int medio, int right )  //O(n)
    {
       int n1= medio - left +1;
       int n2 = right -medio;
       
       int leftArray[] = new int[n1];
       int rightArray[] = new int[n2];
       
       for(int i=0; i<n1 ; i++){
           leftArray[i] = a[left+i];
       }
       for (int i = 0; i < n2; i++) {
            rightArray[i] = a[medio+i+1];
       }
       
       int i=0, j=0;
       int k= left;
       
        while (i<n1 && j<n2) {            
            if(leftArray[i]>= rightArray[j]){
                a[k] = leftArray[j];
                i++;
            }else{
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = leftArray[i];
            i++;
            k++;
        }
        while(i<n2){
            a[k] = leftArray[i];
            i++;
            k++;
        }
        
       
    }
  
  public static void main(String[] args)
  {
      int[] A = {1,2,3,2,6};
      int[] B = {1,5,3,2};
      int[] C = {1,5,2,6};
      int[][] Arrays = {A,B,C};  
      
      for (int[] X : Arrays)
      {        
        mergeSort(X);
        //InsertionSort(X);     
      }
      int cont=1;
      
      for (int[] X : Arrays) {
          //System.out.println("Array: "+ cont);
          for (int i = 0; i < X.length; i++) {
              System.out.println(X[i]);
          }
          cont++;
      }
      
      
      /*for (int i = 10000; i <= 210000; i=i+10000) {
          
          int [] P = new int [i];
          for (int j = 0; j < i; j++) {
              P[j]= j;
          }
          
          /*for (int j = 0; j < P.length; j++) {
              System.out.println(P[j]);
          }
          System.out.println("--------------");
          / #/ 
          long ti = System.currentTimeMillis();
          mergeSort(P);
          //InsertionSort(P);
          long tf = System.currentTimeMillis();
          /*for (int j = 0; j < P.length; j++) {
              System.out.println(P[j]);
          }
          System.out.println("--------------");
          / # /
          System.out.println(tf-ti);
      }*/
  }
  
}