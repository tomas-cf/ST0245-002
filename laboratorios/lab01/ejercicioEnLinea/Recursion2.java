
package recursion;

/**
 *
 * @author NN
 */
public class Recursion2 {
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //C

        if (groupSum6(start + 1, nums, target - nums[start])) return true; //C + T(n-1)
        
        if (nums[start] == 6) target -= 6; //C
        
        return groupSum6(start + 1, nums, target); //C + T(n+1)
        //MODELO: T(n) =    |C, n=0
        //                  |C + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
    
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0; //C1
        return groupNoAdj(start+1,nums,target) ||               
                  groupNoAdj(start+2,nums,target-nums[start]);  //C2+T(n-1)+T(n-2)
        /*
        ECUACION DE RECURRENCIA:
            c_1 Fn + c_2 Ln - c_2
        COMPLEJIDAD:
            O(2^n);
        */
    }
    
    public boolean groupSum5(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0; //C1
        if(nums[start]%5==0 ) return groupSum5(start+1,nums,target-nums[start]); //C2 + T(n-1)
        if(nums[start]==1 && start>=1 && nums[start-1]==5 ) return groupSum5(start+1,nums,target); //C3+ T(n-1)
        return groupSum5(start+1,nums,target) ||        
                groupSum5(start+1,nums,target-nums[start]);     //C4+T(n-1)+T(n-1)
        /*
        ECUACION DE RECURRENCIA:
            C4(2^n-1)+C1*2^n-1
        COMPLEJIDAD:
            
        */
    }
    
    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0; //C1
        if(start<nums.length-1 && nums[start]==nums[start+1] ) //C2
            return groupSumClump(start+2,nums,target) ||                
                      groupSumClump(start+2,nums,target-nums[start]-nums[start+1]); //T(n)= C2+C3+T(n-2)
        return groupSumClump(start+1,nums,target) ||                
                  groupSumClump(start+1,nums,target-nums[start]);   //C4+T(n-1)+T(n-1)
        /*
        ECUACION DE RECURRENCIA:
            C4(2^n-1)+C1*2^n-1
        COMPLEJIDAD:
        
        */
    }

    
    public boolean splitArray(int[] nums) {
        if(nums.length<=0) return true;
        if(nums.length==1) return false;
        return splitArrayAux(0,nums,0,0);
    }

    private boolean splitArrayAux(int start,int[] nums,int sumaUno, int sumaDos){
        if(start>=nums.length) return sumaUno-sumaDos==0; //C1
        return splitArrayAux(start+1,nums,sumaUno+nums[start],sumaDos) ||
               splitArrayAux(start+1,nums,sumaUno,sumaDos+nums[start]); //C2+T(n-1)+T(n-1)
        /*
        ECUACION DE RECURRENCIA:
            C2(2^n-1)+C1*2^n-1
        COMPLEJIDAD:
        
        */
    }

}
