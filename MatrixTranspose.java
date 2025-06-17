public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] t = new int[2][2];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                t[j][i] = a[i][j];

        System.out.println("Transpose:");
        for (int[] row : t) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
