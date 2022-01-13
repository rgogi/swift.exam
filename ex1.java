import java.util.Arrays;

public class ex1 {
    public static Boolean isPalindrome(String text) {
        String[] word;;
        word = text.split("(?!^)");
        for(int i = 1; i < word.length; i++) {
            if(!(word[i-1].equals(word[word.length - i]))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "redivider";
        Boolean flag = isPalindrome(text);
        System.out.println(flag);
    }
}