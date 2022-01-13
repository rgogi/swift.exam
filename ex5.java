

public class ex5 {
    // code with recursion:
    // public static int countVariants(int stearsCount) {
    //     if(stearsCount == 0 || stearsCount == 1) return 1;
    //     return countVariants(stearsCount - 1) + countVariants(stearsCount - 2);
    // }

    public static int countVariants(int stearsCount) {
        int[] counts = new int[stearsCount];
        counts[0] = 1;
        counts[1] = 2;

        for(int i = 2; i < stearsCount; i++) counts[i] = counts[i - 2] + counts[i - 1];
        
        return counts[stearsCount - 1];
    }

    public static void main(String[] args) {
        int stearsCount = 5;
        int ans = countVariants(stearsCount);
        System.out.println(ans);
    }
}
