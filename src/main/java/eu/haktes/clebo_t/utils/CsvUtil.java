package eu.haktes.clebo_t.utils;

import java.io.FileWriter;
import java.io.IOException;

public class CsvUtil {

    public static void writeToFile(String fname, String row) {

        FileWriter fw;
        try {
            fw = new FileWriter(fname + ".csv", true);
            // fw.write(row);
            fw.append(row);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
