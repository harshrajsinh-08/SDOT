import java.util.*;

class wildcardMatching {
  static boolean isAllStars(String S1, int i) {
    for (int j = 1; j <= i; j++) {
      if (S1.charAt(j - 1) != '*')
        return false;
    }
    return true;
  }

  static boolean wildcardMatching(String S1, String S2) {
    int n = S1.length();
    int m = S2.length();

    boolean[] prev = new boolean[m + 1];
    boolean[] cur = new boolean[m + 1];

    prev[0] = true;

    for (int i = 1; i <= n; i++) {
      cur[0] = isAllStars(S1, i);
      for (int j = 1; j <= m; j++) {
        if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
          cur[j] = prev[j - 1];
        } else {
          if (S1.charAt(i - 1) == '*') {
            cur[j] = prev[j] || cur[j - 1];
          } else {
            cur[j] = false;
          }
        }
      }
      prev = cur.clone();
    }

    return prev[m];
  }

  public static void main(String args[]) {
    String S1 = "abdefcd";
    String S2 = "abdefcd";
    System.out.println();
    System.out.println(wildcardMatching(S1, S2) ? "MATCH" : "DONOT MATCH");
  }
}
