public class Radix {
    private static void clear(SortableLinkedList n) {
        while (n.size() > 0) {
            n.remove(0);
        }
    }
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
    public static void radixSortSimple(SortableLinkedList data) {
        int max_length = 0;
        for (int i = 0; i < data.size(); i++) {
            int temp_length = length(data.get(i));
            if (temp_length > max_length) {
                max_length = temp_length;
            }
        }

        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new SortableLinkedList();
        }

        for (int i = 0; i < max_length; i++) {
            for (int j = 0; j < data.size(); j++) {
                buckets[nth(data.get(j),i)].add(data.get(j));
            }
            clear(data);
            merge(data,buckets);
        }
    }
    public static void radixSort(SortableLinkedList data) {
        radixSortSimple(data);
        SortableLinkedList[] buckets = new SortableLinkedList[2];
        for (int i = 0; i < 2; i++) {
            buckets[i] = new SortableLinkedList();
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) < 0) {
                buckets[0].add(0,data.get(i));
            } else {
                buckets[1].add(data.get(i));
            }
        }
        clear(data);
        merge(data,buckets);
    }
}