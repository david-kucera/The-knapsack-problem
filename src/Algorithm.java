public class Algorithm {
    public static int[] getResult(int[] hmotnosti, int[] ceny, int[] zaradene, int r, int K, int n) {

        int[] prehladane = new int[n];
        System.arraycopy(hmotnosti, 0, prehladane, 0, n);

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(zaradene)) && (K < sum(hmotnosti, zaradene)) ) {
            int lowestA = findLowestA(prehladane);
            int indexLowestA = getIndexOf(lowestA, prehladane);

            // nezaradim prvok s najmensou hmotnostou
            zaradene[indexLowestA] = 0;
            prehladane[indexLowestA] = -1;
        }

        // TODO zlepsenie algoritmu ak budem vyberat najskor tie prvky, ktore maju vyssiu cenu, kedze chcem minimalizovat UF

        return zaradene;
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
