public class Radix {
    public static int nth(int n, int col) {
        int m = Math.abs(n);
        return (int) Math.floor(m / Math.pow(10,(col))) % 10;
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
        int max_length = 1;
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new SortableLinkedList();
        }

        for (int i = 0; i < max_length; i++) {
            while (data.size() > 0) {
                int value = data.remove(0);
                buckets[nth(value,i)].add(value);
                if (i == 0) {
                    if (length(value) > max_length) {
                        max_length = length(value);
                    }
                }
            }
            merge(data,buckets);
        }
    }
    public static void radixSort(SortableLinkedList data) {
        radixSortSimple(data);
        SortableLinkedList[] buckets = new SortableLinkedList[2];
        for (int i = 0; i < 2; i++) {
            buckets[i] = new SortableLinkedList();
        }
        while (data.size() > 0) {
            int value = data.remove(0);
            if (value < 0) {
                buckets[0].add(0,value);
            } else {
                buckets[1].add(value);
            }
        }
        merge(data,buckets);
    }
}