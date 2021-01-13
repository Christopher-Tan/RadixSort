public class Radix {
    public static int nth(int n, int col) {
        int m = Math.abs(n);
        return (int) Math.floor(m / Math.pow(10,(col))) - 10 * (int) Math.floor(m / Math.pow(10,(col + 1)));
    }
    public static int length(int n) {
        int m = Math.abs(n);
        if (m == 0) {
            return 1;
        }
        return (int) Math.log10(m) + 1;
    }
    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            original.extend(buckets[i]);
        }
    }
}