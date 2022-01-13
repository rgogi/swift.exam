import java.util.*;

public class ex4 {
    public static Boolean isProperly(String sequence) {
        Stack<Character> prop = new Stack<>();
        for(int i = 0; i < sequence.length(); i++) {
            if(sequence.charAt(i) == '(') prop.push('(');
            if(sequence.charAt(i) == ')' && prop.size() == 0) return false;
            if(sequence.charAt(i) == ')') prop.pop();
        }
        return prop.size() == 0;
    }

    public static void main(String[] args) {
        String sequence = "())()";
        Boolean ans = isProperly(sequence);
        System.out.println(ans);
    }
}
