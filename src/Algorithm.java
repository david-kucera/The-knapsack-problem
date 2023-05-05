import java.util.ArrayList;
import java.util.Collections;

public class Algorithm {
    /*
     * Klasická heuristika podľa zadania.
     */
    public static int[] getResult(int[] hmotnosti, int[] zaradene, int r, int K, int n) {

        int[] prehladane = new int[n];
        System.arraycopy(hmotnosti, 0, prehladane, 0, n);

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(zaradene)) && (K < sum(hmotnosti, zaradene)) ) {
            int lowestA = findLowestA(prehladane);
            int indexLowestA = getIndexOf(lowestA, prehladane);

            // nezaradím prvok s najmenšou hmotnosťou
            zaradene[indexLowestA] = 0;
            prehladane[indexLowestA] = -1;
        }

        return zaradene; // vrátim pole indexov prvkov <0,1> o zaradení
    }

    /*
     * Vylepšenie pôvodnej heuristiky.
     */
    public static int[] getBetterResult(int[] hmotnosti, int[] zaradene, int[] ceny, int r, int K, int n) {

        int[] prehladane = new int[n];
        System.arraycopy(hmotnosti, 0, prehladane, 0, n);

        // hmotnosť batohu musí byť aspoň K a počet predmetov v batohu aspoň r
        while ( (r < sum(zaradene)) && (K < sum(hmotnosti, zaradene)) ) {
            // Nájdem najmenšiu hodnotu hmotnosti spomedzi prvkov
            int lowestA = findLowestA(prehladane);
            // Následne nájdem index toho prvku, ktorý má danú hmotnosť a zároveň maximálnu cenu, keďže minimalizujem ÚF
            int indexLowestA = getIndexOfWithLowestPrice(lowestA, prehladane, ceny);

            // nezaradím prvok s najmenšou hmotnosťou a maximálnou cenou spomedzi rovnakých hodnôt
            zaradene[indexLowestA] = 0;
            prehladane[indexLowestA] = -1;
        }

        return zaradene;
    }

    private static int getIndexOfWithLowestPrice(int lowestA, int[] prehladane, int[] ceny) {
        // vytvorím si pomocné polia s prvkami, ktoré majú rovnakú hmotnosť
        ArrayList<Integer> cenyPrvkovSRovnakouHmotnostou = new ArrayList<>();
        ArrayList<Integer> indexyPrvkovSRovnakouHmotnostou = new ArrayList<>();

        // prechádzam všetky hmotnosti prvkov a hľadám prvky s danou najnižšou hmotnosťou
        for (int i = 0; i < prehladane.length; i++) {
            // akonáhle nájdem prvok s danou hmotnosťou, zapíšem si jeho index a cenu
            if (lowestA == prehladane[i]) {
                indexyPrvkovSRovnakouHmotnostou.add(i);
                cenyPrvkovSRovnakouHmotnostou.add(ceny[i]);
            }
        }

        // akonáhle som dohľadal, spomedzi nich nájdem prvok s NAJVAČŠOU cenou, keďže MINIMALIZUJEM účelovú funkciu
        int maxCena = Collections.max(cenyPrvkovSRovnakouHmotnostou);
        int index = cenyPrvkovSRovnakouHmotnostou.indexOf(maxCena);

        // a vrátim index vrámci prehľadaných hmotností
        return indexyPrvkovSRovnakouHmotnostou.get(index);
    }

    /*
     * Metóda vráti prvý index vrámci poľa hľadaného prvku.
     */
    private static int getIndexOf(int lowestA, int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == lowestA) return i;
        }
        return  -1;
    }

    /*
     * Metóda vráti hodnotu najmenšieho prvku daného poľa.
     */
    private static int findLowestA(int[] p) {
        int min = p[0];
        for (int j : p) {
            if (j == -1) continue;
            if (min > j) min = j;
        }
        return min;
    }

    /*
     * Metóda sčíta sumu hmotností zaradených predmetov v batohu.
     */
    private static int sum(int[] a, int[] z) {
        int sum = 0;
        for (int i = 0; i < z.length; i++) {
            sum += (a[i] * z[i]);
        }
        return sum;
    }

    /*
     * Metóda sčíta počet zaradených prvkov v batohu.
     */
    private static int sum(int[] z) {
        int sum = 0;
        for (int j : z) {
            sum += j;
        }
        return sum;
    }
}
