import java.util.Arrays;

class Eratosphen {
    boolean[] isPrime;

    Eratosphen(int N) {
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < N; i++)
            if (isPrime[i])
                for (int j = i * i; j < N; j += i)
                    isPrime[j] = false;
        printer(isPrime);
    }

    private void printer(boolean[] array) {
        String losos = "1 ";
        for (int i = 0; i < array.length; i++)
            losos += array[i] ? i == 0 ? "" : i + " " : "";
        System.out.println(losos);
    }
}
