import java.util.*;
class balancedparenthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char arr[] = s.toCharArray();
        for(char c:arr){
            if(c=='{'|| c=='(' || c=='['){
                stk.push(c);
            }
            else if(stk.isEmpty() || match(stk.pop(),c) == false){
                return false;
            }
        }
        return stk.isEmpty();
    }

    public boolean match(char l,char r){
        boolean c1 = (l == '(' && r == ')');
        boolean c2 = (l == '{' && r == '}');
        boolean c3 = (l == '[' && r == ']');
        return (c1||c2||c3);
    }
    public static void main(String[] args) {
        balancedparenthesis sol = new balancedparenthesis();
        String s = "{[()]}";
        System.out.println(sol.isValid(s));
    }
}