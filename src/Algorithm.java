import java.util.ArrayList;

public class Algorithm {
    public static int[] getResult(int[] a, int[] c, int[] z, int r, int K, int n) {

        ArrayList<Integer> naPrehladanie = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            naPrehladanie.add(a[i]);
        }

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(z)) && (K <= sum(a, z)) ) {
            int lowestA = findLowestA(naPrehladanie);
            int indexLowestA = getIndex(lowestA, naPrehladanie);

            // vyhodim-nezaradim prvok s najmensou hmotnostou
            z[indexLowestA] = 0;
            naPrehladanie.remove(indexLowestA);
        }

        // tu je uz konecne riesenie

        return z;
    }

    private static int getIndex(int lowestA, ArrayList<Integer> naPrehladanie) {
        for (int i = 0; i < naPrehladanie.size(); i++) {
            if (naPrehladanie.get(i) == lowestA) return i;
        }
        return -1;
    }

    private static int findLowestA(ArrayList<Integer> naPrehladanie) {
        int min = naPrehladanie.get(0);
        for (int i = 0; i < naPrehladanie.size(); i++) {
            if (min > naPrehladanie.get(i)) min = naPrehladanie.get(i);
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
