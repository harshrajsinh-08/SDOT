class Solution {
    private int mod = 1000000007;

    public int countGoodNumbers(long n) {
        long odd = (n+1)/2;
        long oddCount = (n + 1) / 2;
        long evenCount = n / 2;
        long oddPower = modularExponentiation(5, oddCount, mod);
        long evenPower = modularExponentiation(4, evenCount, mod);
        return (int) (oddPower * evenPower % mod);
    }

    private long modularExponentiation(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodNumbers(50));
    }
}

public int rob(int[] nums) {
    int n = nums.length;
    int f[] = new int[n+1];
    f[1]=nums[0];
    for(int i=2;i<=n;i++){
        f[i] = Math.max(f[i-1],f[i-2]+nums[i-1]);
    }
    return f[n-1];
}