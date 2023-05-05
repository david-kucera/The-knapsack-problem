import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class Output {

    /*
     * Statická metóda, ktorá zapíše do súboru výsledné hodnoty po heuristike.
     */
    public static void save(int[] indexy_zaradenych, int celk_pocet, int celk_hmot, int hodnota_uf, String path) throws IOException {
        Writer wr = new FileWriter(path);


        // Zápis výsledku hodnôt
        wr.write("Hodnota ucelovej funkcie: " + hodnota_uf + "\n");
        wr.write("Pocet zaradenych prvkov: " + celk_pocet + "\n");
        wr.write("Celkova hmotnost batoha: " + celk_hmot + "\n");

        // Zápis indexov zaradených predmetov
        wr.write(Arrays.toString(indexy_zaradenych));
        wr.close();
    }
}
