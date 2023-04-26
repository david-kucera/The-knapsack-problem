import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static int[] read(String pathToFile) {
        int[] values = new int[500];
        int index = 0;

        try {
            FileInputStream fis = new FileInputStream(pathToFile);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextInt()) {
                values[index] = sc.nextInt();
                index++;
            }
            sc.close();
        } catch (IOException e) {
//            e.printStackTrace();
            throw new Error("Error reading input file!");
        }
        return values;
    }
}
