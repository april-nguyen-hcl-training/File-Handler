package filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public static void read(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file));) {
            String line;
            System.out.println("----------------\n" +
                    file.getName() +
                    "\n----------------");
            while ( (line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        }
    }
}
