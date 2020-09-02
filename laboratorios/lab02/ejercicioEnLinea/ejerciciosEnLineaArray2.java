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
public class ejerciciosEnLineaArray2 {
     public int countEvens(int[] nums) {
        int count = 0;//        C
        for (int n : nums) {//  n
            if (n % 2 == 0) {// n
                count++;    //  n
            }
        }
        return count;       //C
        //Complejidad O(n)
    }
     
     public int bigDiff(int[] nums) {
        int max= nums[0], min =nums[0];
        for(int i=1;i<nums.length;i++){
         max= Math.max(max,nums[i]);
        min= Math.min(min,nums[i]);
        }
        return max-min;
    }
    
     public int centeredAverage(int[] nums) {
        for(int i=0;i<nums.length;i++){
          for(int j=0;j<nums.length-1;j++){
            if(nums[j]<nums[j+1]){
              int aux= nums[j];
              nums[j]=nums[j+1];
              nums[j+1]=aux;
            }
          }
        }
        int sum=0;
        for(int i=1; i<nums.length-1;i++){
          sum+=nums[i];
        }
        return sum/(nums.length-2);
      }
    public int sum13(int[] nums) {
        if(nums.length==0) return 0;
        int suma= 0;
        for(int i=0; i<nums.length;i++){
          suma+=nums[i];
          if(nums[i]==13) {
            suma-=nums[i];
            i++;
          }
        }

        return suma;
    }
    
    public int sum67(int[] nums) {
        int suma = 0;
        boolean seven=false;
        for(int i =0; i<nums.length; i++){
          if(nums[i]==6)
            seven=true;
          if(!seven)
            suma+=nums[i];
          if(seven)
            if(nums[i]==7)
              seven=false;

        }

        return suma;
     }
}
