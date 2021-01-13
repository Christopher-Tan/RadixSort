import java.util.Random;
import java.util.Arrays;
public class Tester {
    public static void main(String[] args) {
        System.out.println("\nnth");
        System.out.println(Radix.nth(123,1));
        System.out.println(Radix.nth(-123,1));
        System.out.println(Radix.nth(123,2));
        System.out.println(Radix.nth(-123,2));
        int m = 1432413241;
        for (int i = 0; i < Math.log10(m); i++) {
            System.out.print(Radix.nth(m,i));
        }
        System.out.println("\nlength");
        System.out.println(Radix.length(0));
        System.out.println(Radix.length(15));
        System.out.println(Radix.length(-10));
        System.out.println(Radix.length(5112));
        System.out.println("\nmerge");
        SortableLinkedList original = new SortableLinkedList();
        SortableLinkedList[] buckets = new SortableLinkedList[5];
        for (int i = 0; i < buckets.length; i++) {
            Random creator = new Random();
            SortableLinkedList temp = new SortableLinkedList();
            for (int j = 0; j < creator.nextInt(10); j++) {
                temp.add(creator.nextInt());
            }
            buckets[i] = temp;
            System.out.println(temp);
        }
        Radix.merge(original,buckets);
        System.out.println(original);
        System.out.println(Arrays.toString(buckets));
        System.out.println("\nradixsimple");
        SortableLinkedList tester = new SortableLinkedList();
        int[] t = {12,34,42,32,44,41,34,11,32,23,87,50,77,58,8};
        for (int i = 0; i < t.length; i++) {
            tester.add(t[i]);
        }
        Radix.radixSortSimple(tester);
        System.out.println(tester);
        tester = new SortableLinkedList();
        int[] j = {143312,34324,442,32,4,4143215,345315431,11,324567,232342,874325,501234,773213,585432,863163};
        for (int i = 0; i < j.length; i++) {
            tester.add(j[i]);
        }
        Radix.radixSortSimple(tester);
        System.out.println(tester);
    }
}