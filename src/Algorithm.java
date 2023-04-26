public class Algorithm {
    public static int[] getResult(int[] a, int[] c, int[] z, int r, int K, int n) {
        int[] result = new int[n];

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r >= sum(z)) && (K >= sum(a, z)) ) {
            // TODO algo
        }

        // tu je uz konecne riesenie

        return result;
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
