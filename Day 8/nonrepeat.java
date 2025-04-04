import java.util.*;
class nonrepeat {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        int l=0,r=0,n=s.length(),len=0;
        while(r<n){
            if(mpp.containsKey(s.charAt(r))){
                l=Math.max(mpp.get(s.charAt(r))+1,l);
            }
            mpp.put(s.charAt(r),r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        nonrepeat obj = new nonrepeat();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}