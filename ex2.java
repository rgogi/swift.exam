

public class ex2 {
    public static int minSplit(int amount) {
        int counter = 0;

        int c1 = amount / 50;
        counter = amount % 50;

        int c2 = counter / 20 ;
        counter = counter % 20;

        int c3 = counter / 10;
        counter = counter % 10;

        int c4 = counter / 5;

        return c1 + c2 + c3 + c4;
    }

    public static void main(String[] args) {
        int amount = 95;
        int ans = minSplit(amount);
        System.out.println(ans);
    }
}
