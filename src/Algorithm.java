import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Algorithm {
    /*
     * Klasicka heuristika podla zadania
     */
    public static int[] getResult(int[] hmotnosti, int[] zaradene, int r, int K, int n) {

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

        return zaradene; // vratim pole indexov prvkov <0,1> o zaradeni
    }

    public static int[] getBetterResult(int[] hmotnosti, int[] zaradene, int[] ceny, int r, int K, int n) {

        int[] prehladane = new int[n];
        System.arraycopy(hmotnosti, 0, prehladane, 0, n);

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(zaradene)) && (K < sum(hmotnosti, zaradene)) ) {
            // Najdem najmensiu hodnotu hmotnosti spomedzi prvkov
            int lowestA = findLowestA(prehladane);
            // Nasledne najdem index toho prvku, ktory ma danu hmotnost a zaroven maximalnu cenu, kedze minimalizujem UF
            int indexLowestA = getIndexOfWithLowestPrice(lowestA, prehladane, ceny);

            // nezaradim prvok s najmensou hmotnostou a maximalnou cenou spomedzi rovnakych hodnot
            zaradene[indexLowestA] = 0;
            prehladane[indexLowestA] = -1;
        }

        return zaradene;
    }

    private static int getIndexOfWithLowestPrice(int lowestA, int[] prehladane, int[] ceny) {
        // vytvorim si pomocne pole s prvkami, ktore maju rovnaku hmotnost
        ArrayList<Integer> cenyPrvkovSRovnakouHmotnostou = new ArrayList<>();
        ArrayList<Integer> indexyPrvkovSRovnakouHmotnostou = new ArrayList<>();

        // prechadzam vsetky hmotnosti prvkov a hladam prvky s danou najnizsou hmotnostou
        for (int i = 0; i < prehladane.length; i++) {
            // akonahle najdem prvok s danou hmotnostou, zapisem si jeho index a cenu
            if (lowestA == prehladane[i]) {
                indexyPrvkovSRovnakouHmotnostou.add(i);
                cenyPrvkovSRovnakouHmotnostou.add(ceny[i]);
            }
        }

        // akonahle som dohladal, spomedzi nich najdem prvok s NAJVACSOU cenou, kedze MINIMALIZUJEM ucelovu funkciu
        int maxCena = Collections.max(cenyPrvkovSRovnakouHmotnostou);
        int index = cenyPrvkovSRovnakouHmotnostou.indexOf(maxCena);

        // a vratim index vramci prehladanych hmotnosti
        return indexyPrvkovSRovnakouHmotnostou.get(index);
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
