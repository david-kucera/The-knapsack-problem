import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] hmotnosti = Input.read("src/H3_a.txt");
        int[] ceny = Input.read("src/H3_c.txt");

        int pocet_prvkov = 500;
        int pocet_batoh = 350;
        int kapacita_batoh = 9500;
        int[] zaradene = new int[pocet_prvkov];

        // Zaradím všetky predmety do batoha - východzie riešenie
        for (int i = 0; i < pocet_prvkov; i++) {
            zaradene[i] = 1;
        }

        // * lokálne kritérium: *
        // „Odstráň prvok z dosiaľ nespracovaných prvkov, ktorý má najmenšiu hmotnosť“.

        // --- VÝPIS PRED HEURISTIKOU ---

        System.out.println("===Vychodzie hodnoty batoha pred heuristikou===");
        int totalZ = 0;
        for (int j : zaradene) {
            totalZ += j;
        }
        System.out.println("Pocet prvkov v batohu: " + totalZ);

        int totalA = 0;
        for (int i = 0; i < hmotnosti.length; i++) {
            totalA += zaradene[i] * hmotnosti[i];
        }
        System.out.println("Hmnotnost batohu: " + totalA);

        int totalC = 0;
        for (int i = 0; i < ceny.length; i++) {
            totalC += zaradene[i] * ceny[i];
        }
        System.out.println("Celkova hodnota ucelovej funkcie: " + totalC);
        System.out.println();

        // --- VÝPIS VÝSLEDKOV  HEURISTIKY ---

        int[] result = Algorithm.getResult(hmotnosti, zaradene, pocet_batoh, kapacita_batoh, pocet_prvkov);
        // ODKOMENTUJ TENTO RIADOK PRE ZLEPŠENIE VÝSLEDKOV HEURISTIKY A ZAKOMENTUJ RIADOK VYŠŠIE
//        int[] result = Algorithm.getBetterResult(hmotnosti, zaradene, ceny, pocet_batoh, kapacita_batoh, pocet_prvkov);

        System.out.println("===Vysledne hodnoty batoha po heuristike===");
        int _pocetPrvkov_celkovo = 0;
        for (int j : result) {
            _pocetPrvkov_celkovo += j;
        }
        System.out.println("Pocet prvkov v batohu: " + _pocetPrvkov_celkovo);

        int _hmotnost_celkovo = 0;
        for (int i = 0; i < hmotnosti.length; i++) {
            _hmotnost_celkovo += result[i] * hmotnosti[i];
        }
        System.out.println("Hmnotnost batohu: " + _hmotnost_celkovo);

        int _hodnota_uf_celkovo = 0;
        for (int i = 0; i < ceny.length; i++) {
            _hodnota_uf_celkovo += result[i] * ceny[i];
        }
        System.out.println("Celkova hodnota ucelovej funkcie: " + _hodnota_uf_celkovo);

        int[] indexy_zaradenych = new int[_pocetPrvkov_celkovo];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                indexy_zaradenych[index] = i;
                index++;
            }
        }

        // Zápis do súboru
        try {
            Output.save(indexy_zaradenych, _pocetPrvkov_celkovo, _hmotnost_celkovo, _hodnota_uf_celkovo, "src/R.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
