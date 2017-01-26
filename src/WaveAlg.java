import java.util.Random;

/**
 * Created by Dns on 26.01.2017.
 */
public class WaveAlg {
    private static Random random = new Random();
    private int[][] matrix;

    public WaveAlg(int n) {
        matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = (i == 0 || i == n - 1) || (j == 0 || j == n - 1) ? -1 : random.nextInt(1) - 1;

        matrix[0][random.nextInt(n - 1)] = 0;
        matrix[n - 1][random.nextInt(n - 1)] = (n * n) + 1;
    }



}
