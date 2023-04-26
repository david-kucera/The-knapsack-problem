import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = Input.read("src/H3_a.txt");
	    int[] c = Input.read("src/H3_c.txt");
//        System.out.println(Arrays.toString(c));
//        System.out.println(Arrays.toString(a));

        int n = 500;
        int r = 350;
        int K = 9500;
        int[] z = new int[n];

        // Zaradim vsetky predmety do batoha
        for (int i = 0; i < n; i++) {
            z[i] = 1;
        }

        int[] result = Algorithm.getResult(a, c, z, r, K, n);
        System.out.println(Arrays.toString(result));
    }
}
