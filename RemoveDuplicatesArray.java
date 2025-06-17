public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5};
        int n = arr.length;

        if (n == 0 || n == 1) return;

        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) temp[j++] = arr[i];
        }
        temp[j++] = arr[n - 1];

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < j; i++) System.out.print(temp[i] + " ");
    }
}
