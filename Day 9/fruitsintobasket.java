class fruitsintobasket {
    public int totalFruit(int[] fruits) {
        int maxlen = 0;
        java.util.Map<Integer,Integer> map = new java.util.HashMap<>();
        int left = 0;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;

            }
            maxlen = Math.max(maxlen,right-left+1);
        }     
        return maxlen;
    }
    public static void main(String[] args) {
        fruitsintobasket sol = new fruitsintobasket();
        int[] fruits = {1,2,1};
        int result = sol.totalFruit(fruits);
        System.out.println(result);
    }
}