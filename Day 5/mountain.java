/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
    public MountainArray mt;
    public int target;
    public int search(int l,int r,int k){
        while(l<r){
            int mid = (l+r)/2;
            if (k * mt.get(mid) >= k * target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if(mt.get(l) == target) return l;
        else{
            return -1;
        }
    }
    public int findInMountainArray(int target, MountainArray mt) {
        int n = mt.length();
        int l=0;
        int r = n-1;
        while(l<r){
            int mid = (l+r)/2;
            if(mt.get(mid) > mt.get(mid+1)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
            this.mt = mt;
            this.target = target;
            int ans = search(0,l,1);
            if(ans == -1){
                return search(l + 1, n-1, -1);
            }
            else return ans;
    }
}