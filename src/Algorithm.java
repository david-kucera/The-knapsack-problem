import java.util.ArrayList;

public class Algorithm {
    public static int[] getResult(int[] a, int[] c, int[] z, int r, int K, int n) {

        ArrayList<Integer> vyhodeneHmotnosti = new ArrayList<Integer>();
        ArrayList<Integer> vyhodeneCeny = new ArrayList<Integer>();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = a[i];
        }

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(z)) && (K <= sum(a, z)) ) {
            int lowestA = findLowestA(p);
            int indexLowestA = getIndexOf(lowestA, p);

            vyhodeneHmotnosti.add(a[indexLowestA]);
            vyhodeneCeny.add(c[indexLowestA]);

            // nezaradim prvok s najmensou hmotnostou
            z[indexLowestA] = 0;
            p[indexLowestA] = -1;
        }

        // TODO zlepsenie algoritmu ak budem vyberat najskor tie prvky, ktore maju vyssiu cenu, kedze chcem minimalizovat UF

        System.out.println(vyhodeneHmotnosti);
        System.out.println(vyhodeneCeny);

        return z;
    }

    private static int getIndexOf(int lowestA, int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == lowestA) return i;
        }
        return  -1;
    }

    private static int findLowestA(int[] p) {
        int min = p[0];
        for (int i = 0; i < p.length; i++) {
            if (p[i] == -1) continue;
            if (min > p[i]) min = p[i];
        }
        return min;
    }

    private static int sum(int[] a, int[] z) {
        int sum = 0;
        for (int i = 0; i < z.length; i++) {
            sum += (a[i] * z[i]);
        }
        return sum;
    }

    private static int sum(int[] z) {
        int sum = 0;
        for (int i = 0; i < z.length; i++) {
            sum += z[i];
        }
        return sum;
    }
}
