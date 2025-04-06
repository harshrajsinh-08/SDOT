class longchar_repl {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int l = 0, maxf = 0, maxlen = 0;

        for (int r = 0; r < s.length(); r++) {
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxf > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        longchar_repl obj = new longchar_repl();
        String s = "AABABBA";
        int k = 2;
        int result = obj.characterReplacement(s, k);
        System.out.println("The length of the longest substring is: " + result);
    }
}