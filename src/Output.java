import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class Output {

    public static void save(int[] indexy_zaradenych, int celk_pocet, int celk_hmot, int hodnota_uf, String path) throws IOException {
        Writer wr = new FileWriter(path);


        // Zapis vysledku hodnot
        wr.write("Hodnota ucelovej funkcie: " + Integer.toString(hodnota_uf) + "\n");
        wr.write("Pocet zaradenych prvkov: " + Integer.toString(celk_pocet) + "\n");
        wr.write("Celkova hmotnost batoha: " + Integer.toString(celk_hmot) + "\n");

        // Zapis indexov zaradenych predmetov
        wr.write(Arrays.toString(indexy_zaradenych));
        wr.close();
    }
}
