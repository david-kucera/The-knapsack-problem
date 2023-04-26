public class Algorithm {
    public static int[] getResult(int[] a, int[] c, int[] z, int r, int K, int n) {

//        System.out.println(r);
//        System.out.println(sum(z));
//        System.out.println(K);
//        System.out.println(sum(a,z));
        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r <= sum(z)) && (K <= sum(a, z)) ) {
            int lowestA = findLowestA(a);
            System.out.println(lowestA);
            int indexLowestA = getIndex(lowestA, a);
            System.out.println(lowestA);
            z[indexLowestA] = 0; // vyhodim-nezaradim prvok s najmensou hmotnostou
        }

        // tu je uz konecne riesenie

        return z;
    }

    private static int getIndex(int lowestA, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == lowestA) return i;
        }
        return -1;
    }

    private static int findLowestA(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) min = a[i];
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
