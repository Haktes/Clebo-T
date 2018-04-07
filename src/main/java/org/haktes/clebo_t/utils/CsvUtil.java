package org.haktes.clebo_t.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvUtil {

    /**
     * Return true if directory exists
     */
    private static boolean doesTheFileExist(String path) {

        File file = new File("path");
        if (file.exists() && !file.isDirectory()) {
            return true;
        }

        return false;
    }

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
