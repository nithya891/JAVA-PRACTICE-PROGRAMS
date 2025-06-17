public class ArrayMerge {
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int[] merged = new int[a.length + b.length];

        int i = 0;
        for (int val : a) merged[i++] = val;
        for (int val : b) merged[i++] = val;

        System.out.print("Merged array: ");
        for (int val : merged) System.out.print(val + " ");
    }
}
