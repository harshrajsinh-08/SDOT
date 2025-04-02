import java.util.*;
class min_deletion {
    public int gcd(int a,int b){
        if (a == 0) return b;
        return gcd(b%a, a);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int g = gcd(nums[i], numsDivide[0]);
            for(int j=1;j<numsDivide.length;j++){
                g = gcd(g, numsDivide[j]);
            }
            if(g%nums[i] == 0){
                return i;
            }
        }
        return -1;
    }
public static void main(String[] args) {
    min_deletion solution = new min_deletion();
    int[] nums = {2,3,2,4,3};
    int[] numsDivide = {9,6,9,3,15};
    System.out.println(solution.minOperations(nums, numsDivide)); 
}
}