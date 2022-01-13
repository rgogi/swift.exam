import java.util.*;

public class ex3 {
    public static int notContains(int[] array) {
        Set<Integer> numbers = new LinkedHashSet<Integer>();
        for(int i = 0; i < array.length; i++) {
            if(array[i] > 0) numbers.add(array[i]);
        }
        
        int ans = 1;
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.contains(ans)) ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, -1, 3, 4, -20, 5, 6, 8, 9, 10};
        int ans = notContains(array);
        System.out.println(ans);
    }
}
