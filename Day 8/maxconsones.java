import java.util.Scanner;
class maxconsones {
    public int consecones(int[] nums,int k){
        int l=0,r=0,len=0,maxlen=0,zero=0;
        while(r<nums.length){
            if(nums[r]==0){
                zero++;
            }
            if(zero>k){
                if(nums[l]==0){
                    zero--;
                }
                l++;
            }
            if(zero<=k){
                len=r-l+1;
            }
            maxlen = Math.max(len,maxlen);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        maxconsones obj = new maxconsones();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        int result = obj.consecones(nums, k);
        System.out.println("Ans: "+result);
    }
}