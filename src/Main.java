import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = Input.read("src/H3_a.txt");
	    int[] c = Input.read("src/H3_c.txt");

        int n = 500;
        int r = 350;
        int K = 9500;
        int[] z = new int[n];

        // Zaradim vsetky predmety do batoha
        for (int i = 0; i < n; i++) {
            z[i] = 1;
        }

        // --- VYPIS VYSLEDKOV HEURISTIKY ---

        int[] result = Algorithm.getResult(a, c, z, r, K, n);
        System.out.println(Arrays.toString(result));

        System.out.println("Vysledne hodnoty batoha po heuristike: ");
        int totalZ = 0;
        for (int i = 0; i < z.length; i++) {
            totalZ += z[i];
        }
        System.out.println("Pocet prvkov v batohu: " + totalZ);

        int totalA = 0;
        for (int i = 0; i < a.length; i++) {
            totalA += z[i] * a[i];
        }
        System.out.println("Hmnotnost batohu: " + totalA);

        int totalC = 0;
        for (int i = 0; i < c.length; i++) {
            totalC += z[i] * c[i];
        }
        System.out.println("Celkova hodnota ucelovej funkcie: " + totalC);
    }
}
