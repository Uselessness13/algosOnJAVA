import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of values in array");
        int n = scanner.nextInt();
        Eratosphen eratosphen = new Eratosphen(n);
        ArrayList<Integer> a = new ArrayList<Integer>();
        String los = "";
        for (int i = 0; i < n; i++) {
            a.add(random.nextInt(n*n));
            los += a.get(i)+ " ";
        }
        System.out.println(los);



        Search search = new Search();

        Sort sort = new Sort();
        sort.insertion(a);
        los = "";
        for (int i = 0; i < n; i++) {
            los += a.get(i)+ " ";
        }
        System.out.println(los);

        System.out.println("Enter some value");
        int x = Integer.parseInt(scanner.next());
        long binstart = System.nanoTime();
        System.out.println(Search.binary(a, x));
        long endbin = System.nanoTime();
        System.out.println("BinTime = "+(endbin-binstart));

        long linstart = System.nanoTime();
        System.out.println(search.linear(a, x));
        long endlin = System.nanoTime();
        System.out.println("LinTime = "+(endlin-linstart));
    }

}
