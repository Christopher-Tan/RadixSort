public class Tester {
    public static void main(String[] args) {
        System.out.println(Radix.nth(123,1));
        System.out.println(Radix.nth(-123,1));
        System.out.println(Radix.nth(123,2));
        System.out.println(Radix.nth(-123,2));
        int m = 1432413241;
        for (int i = 0; i < Math.log10(m); i++) {
            System.out.print(Radix.nth(m,i));
        }
    }
}