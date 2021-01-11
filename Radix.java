public class Radix {
    public static int nth(int n, int col) {
        int m = Math.abs(n);
        return (int) Math.floor(m / Math.pow(10,(col))) - 10 * (int) Math.floor(m / Math.pow(10,(col + 1)));
    }
}