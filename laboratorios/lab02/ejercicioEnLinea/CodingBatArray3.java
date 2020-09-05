public class CodingBatArray3 {

    //maxSpan
    
    public int maxSpan(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = nums.length-1; j >= i; j--) {
                if(nums[i]==nums[j]) {
                    if((j-i+1)>max) {
                        max = j-i+1;
                    }
                    break;
                }
            }
        }
        return max;
    }
    
    //fix34
    
    public int[] fix34(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 3) {
                int temp = nums[i+1];
                nums[i+1] = 4;
                for (int j = 0; j < nums.length; j++){
                    if(nums[j] == 4 && nums[j - 1] != 3){
                        nums[j] = temp;
                    }
                }
            }
        }
        return nums;
    }
    
    //fix45
    
    public int[] fix45(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 4) {
                int temp = nums[i+1];
                nums[i+1] = 5;
                for (int j = 1; j < nums.length; j++){
                    if(nums[j] == 5 && nums[j - 1] != 4) {
                        nums[j] = temp;
                    } else if(nums[0]==5) {
                        nums[0]=temp;

                    }
                }
            }
        }
        return nums;
    }

    //canBalance
    
    public boolean canBalance(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int sum1 = 0, sum2 = 0;
            for(int a = 0; a < i; a++) sum1 += nums[a];
            for(int b = i; b < nums.length; b++) sum2 += nums[b];
            if(sum1 == sum2) return true;
        }
        return false;
    }
    
    //seriesUp
    
    public int[] seriesUp(int n) {
        int [] nums = new int [n*(n+1)/2];
        int p = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=i; j++) {
                nums[p] = j;
                p++;
            }
        }
        return nums;
    }

}