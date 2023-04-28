import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int[] hmotnosti = Input.read("src/H3_a.txt");
        int[] ceny = Input.read("src/H3_c.txt");

        int pocet_prvkov = 500;
        int pocet_batoh = 350;
        int kapacita_batoh = 9500;
        int[] zaradene = new int[pocet_prvkov];

        // Zaradim vsetky predmety do batoha - vzchodzie riesenie
        for (int i = 0; i < pocet_prvkov; i++) {
            zaradene[i] = 1;
        }

        // --- VYPIS PRED HEURISTIKOU ---

        System.out.println("===Vychodzie hodnoty batoha pred heuristikou===");
        int totalZ = 0;
        for (int i = 0; i < zaradene.length; i++) {
            totalZ += zaradene[i];
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

        // --- VYPIS VYSLEDKOV HEURISTIKY ---

        int[] result = Algorithm.getResult(hmotnosti, ceny, zaradene, pocet_batoh, kapacita_batoh, pocet_prvkov);

        System.out.println("===Vysledne hodnoty batoha po heuristike===");
        int _pocetPrvkov_celkovo = 0;
        for (int i = 0; i < result.length; i++) {
            _pocetPrvkov_celkovo += result[i];
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
            if (result[i] == 0) continue;
            else {
                indexy_zaradenych[index] = i;
                index++;
            }
        }

        // Zapis do suboru
        try {
            Output.save(indexy_zaradenych, _pocetPrvkov_celkovo, _hmotnost_celkovo, _hodnota_uf_celkovo, "src/R.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
