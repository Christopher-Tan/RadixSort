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
    }
}